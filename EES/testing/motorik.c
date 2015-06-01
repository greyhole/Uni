/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
#include "motorik.h"
#include <math.h>
#include <stdlib.h>
#include <stdio.h>

#define ROTATE_L    -1
#define ROTATE_R    1
#define MOVE_LINE   2
#define ADJUST_F    3
#define MOVE_F      4
#define MOVE_B      5
#define HAPPYENDING 6
#define MOVE_B2     7

#define FORWARD 1
#define BACKWARD -1
#define STOP 12
#define RPSNORM 80

#define TA 0.03
#define KP 10
#define KD 0
#define KI 0

#define FORWARDVAL 800
#define BACKWARDVAL  200 
#define ROTATEVAL 465
#define RPMMULTI 100
int err = 0; 
struct motorikCmd_t {
  int cmdLst[10];
  int cmdCnt;
};

struct motor_t {
  U32 motor;
  float rpsNorm;
  float speed;
  unsigned int mCnt;
  float errorOld;
  float errorSum;
  int moveRps;
};

char xxxx[10] = "BEGIN";
struct motorikCmd_t lapse = { {100}, 0 };

struct motor_t motorRight = { MOTOR_RIGHT,0,0,0,0,0,RPSNORM };
struct motor_t motorLeft = { MOTOR_LEFT,0,0,0,0,0,RPSNORM };
struct motorikLight_t lightVal;

void motorReset(){
 motorRight.mCnt = 0; 
 motorLeft.mCnt = 0;
}

void moveF(){
  motorReset();
  lapse.cmdLst[0] = ADJUST_F;
  lapse.cmdLst[1] = MOVE_LINE;
  lapse.cmdLst[2] = MOVE_F;
  lapse.cmdLst[3] = ADJUST_F;
  lapse.cmdLst[4] = HAPPYENDING;
}


void rotateL(){
  motorReset();
  lapse.cmdLst[0] = MOVE_B;
  lapse.cmdLst[1] = ROTATE_L;
  lapse.cmdLst[2] = ADJUST_F;
  lapse.cmdLst[3] = HAPPYENDING;
}

void rotateR(){
  motorReset();
  lapse.cmdLst[0] = MOVE_B;
  lapse.cmdLst[1] = ROTATE_R;
  lapse.cmdLst[2] = ADJUST_F;
  lapse.cmdLst[3] = HAPPYENDING;
}

void adjust(){
  motorReset();
  lapse.cmdLst[0] = ADJUST_F;
  lapse.cmdLst[1] = HAPPYENDING;
}

void motorSet(struct motor_t *motor,int direction, int rps){
 
  switch(direction){
    case FORWARD:
        motor->rpsNorm = rps;
        nxt_motor_set_speed(motor->motor,motor->speed,1);
    break;
    case STOP:
      motor->rpsNorm = 0;
      motor->speed = 0;
      nxt_motor_set_speed(motor->motor,0,1);
      break;
    case BACKWARD:
      motor->rpsNorm = rps;
      nxt_motor_set_speed(motor->motor,-(motor->speed),1);
      break;
  }
}

void adjustFUN(){
        //
        //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
        //
        if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
          motorSet(&motorRight,FORWARD, RPSNORM);
          motorSet(&motorLeft,BACKWARD, RPSNORM);
        }
        //
        //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
        //
        else if((lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
          motorSet(&motorRight,BACKWARD,RPSNORM);
          motorSet(&motorLeft,FORWARD,RPSNORM);
        }
        //
        //wenn Kontakt mit beiden Sensoren bleibe stehen
        //
        else if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight > lightVal.initRight)){
          motorSet(&motorRight,STOP,RPSNORM);
          motorSet(&motorLeft,STOP,RPSNORM);
          lightVal.oldLeft = lightVal.newLeft;
          lightVal.oldRight = lightVal.newRight;
          motorReset();
          lapse.cmdCnt++;
        }
        else{
          motorSet(&motorRight,FORWARD,RPSNORM);
          motorSet(&motorLeft,FORWARD,RPSNORM);
        }
}


void rotateFUN(int direction){
        if( motorRight.mCnt <= ROTATEVAL ){
          motorSet(&motorRight,direction*BACKWARD,RPSNORM);
        }
        else{
          motorSet(&motorRight,STOP,RPSNORM);
        }
        if (motorLeft.mCnt <= ROTATEVAL ){
          motorSet(&motorLeft,direction*FORWARD,RPSNORM);
        }
        else{
          motorSet(&motorLeft,STOP,RPSNORM);
        }
        if ( (motorRight.mCnt >= ROTATEVAL ) && (motorLeft.mCnt >= ROTATEVAL )){
          motorReset();
          lapse.cmdCnt++;
        }
}

void move_lineFUN(){
      if((lightVal.newRight <= lightVal.initRight ) || (lightVal.newLeft <= lightVal.initLeft)){
        lapse.cmdCnt++;
        motorReset();
      }
      else{
        motorSet(&motorRight,FORWARD,RPSNORM);
        motorSet(&motorLeft,FORWARD,RPSNORM);
      }
}


void moveFUN(int direction, int distance, int safe){
      if((motorRight.mCnt >= distance) && (motorLeft.mCnt >= distance)){
        motorReset();
        lapse.cmdCnt++;
        return;
      }
      else if(safe && (motorLeft.mCnt > 10) && (lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
          err = motorLeft.mCnt;
          lapse.cmdLst[lapse.cmdCnt] = MOVE_B2;
          lapse.cmdLst[lapse.cmdCnt+1] = MOVE_F;
          lapse.cmdLst[lapse.cmdCnt+2] = ADJUST_F;
          lapse.cmdLst[lapse.cmdCnt+3] = HAPPYENDING;
          motorLeft.moveRps = 100;
          motorReset();
        }
        else if(safe &&  (motorRight.mCnt > 10) && (lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
          err = motorRight.mCnt;
          lapse.cmdLst[lapse.cmdCnt] = MOVE_B2;
          lapse.cmdLst[lapse.cmdCnt+1] = MOVE_F;
          lapse.cmdLst[lapse.cmdCnt+2] = ADJUST_F;
          lapse.cmdLst[lapse.cmdCnt+3] = HAPPYENDING;
          motorRight.moveRps = 100;
          motorReset();
        }
      else{
        motorSet(&motorRight,direction,motorRight.moveRps);
        motorSet(&motorLeft,direction,motorLeft.moveRps);
      }
  }


void readyFUN(){
  lapse.cmdCnt = 0;
  memset(lapse.cmdLst, 100, sizeof(lapse.cmdLst));
  SetEvent(MainTask, MoveReadyEvent);
}

void pidFUN(struct motor_t *motor){
  int cntNew = 0;
  float error = 0;
  float rpmNew = 0;
  float pid = 0;

  cntNew = abs(nxt_motor_get_count(motor->motor));
  motor->mCnt += cntNew;
  rpmNew = (cntNew / (360*TA));
  error = (motor->rpsNorm)/RPMMULTI - rpmNew;
  (motor->errorSum) += error;
  pid = (KP * error) + (Q0 * (motor->errorSum)) + (Q1 * (error - (motor->errorOld)));
  (motor->errorOld) = error;
  if( pid > 3 ){
    motor->speed += 3;
  }
  else if( pid < -3){
  (motor->speed) -= -3;
  }
  else{
  (motor->speed) += pid;
   }
}
void motorikTask(){
  display_clear(0);
  pidFUN(&motorLeft);
  pidFUN(&motorRight);
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  
  if(lapse.cmdLst[0] != 100){
    lightVal.newRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
    lightVal.newLeft = ecrobot_get_light_sensor(LIGHT_LEFT);

    switch(lapse.cmdLst[lapse.cmdCnt]){
      case ADJUST_F:
        adjustFUN(FORWARD);
        motorReset();
        memcpy(xxxx,"ADJUST_F",10);
        break;
      case MOVE_B:
        moveFUN(BACKWARD,BACKWARDVAL, 0);
        memcpy(xxxx,"MOVE_B",10);
        break;
      case MOVE_B2:
        moveFUN(BACKWARD,err, 0);
        memcpy(xxxx,"MOVE_B2",10);
        break;
      case ROTATE_R:
        rotateFUN(ROTATE_R);
        memcpy(xxxx,"ROTATE_R",10);
        break;

      case ROTATE_L:
        rotateFUN(ROTATE_L);
        memcpy(xxxx,"ROTATE_L",10);
        break;

      case MOVE_LINE:
        move_lineFUN();
        memcpy(xxxx,"MOVE_LINE",10);
        break;
        
      case MOVE_F:
        moveFUN(FORWARD,FORWARDVAL,1);
        memcpy(xxxx,"MOVE_F",10);
        break;

      case HAPPYENDING:
        motorRight.moveRps = 80;
        motorLeft.moveRps = 80;
        motorReset();
        readyFUN();
        memcpy(xxxx,"HAPPYEND",10);
        break;
    }
    
  }
    display_goto_xy(5,3);
    display_string(xxxx);
    display_goto_xy(0,0);
    display_int(motorRight.mCnt,4);
    display_goto_xy(0,1);
    display_int(motorLeft.mCnt,4);
    display_update();
}
