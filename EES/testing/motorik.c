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
#define ADJUST      3
#define MOVE_F      4
#define MOVE_B      5
#define HAPPYENDING 6


#define FORWARD 1
#define BACKWARD -1
#define STOP 12
#define RPMNORM 80

#define TA 0.03
#define KP 10
#define KD 0
#define KI 0

#define FORWARDVAL 970
#define BACKWARDVAL  200 
#define ROTATEVAL 465
#define RPMMULTI 100

struct motorikCmd_t {
  int cmdLst[10];
  int cmdCnt;
};

struct motor_t {
  U32 motor;
  float rpmNorm;
  float speed;
  unsigned int mCnt;
  float errorOld;
  float errorSum;
};

char xxxx[10] = "BEGIN";
struct motorikCmd_t lapse = { {100}, 0 };

struct motor_t motorRight = { MOTOR_RIGHT,0,0,0,0,0 };
struct motor_t motorLeft = { MOTOR_LEFT,0,0,0,0,0 };
struct motorikLight_t lightVal;

void motorReset(){
 motorRight.mCnt = 0; 
 motorLeft.mCnt = 0;
}

void moveF(){
  motorReset();
  lapse.cmdLst[0] = ADJUST;
  lapse.cmdLst[1] = MOVE_LINE;
  lapse.cmdLst[2] = MOVE_F;
  lapse.cmdLst[3] = ADJUST;
  lapse.cmdLst[4] = HAPPYENDING;
}


void rotateL(){
  motorReset();
  lapse.cmdLst[0] = MOVE_B;
  lapse.cmdLst[1] = ROTATE_L;
  lapse.cmdLst[2] = ADJUST;
  lapse.cmdLst[3] = HAPPYENDING;
}

void rotateR(){
  motorReset();
  lapse.cmdLst[0] = MOVE_B;
  lapse.cmdLst[1] = ROTATE_R;
  lapse.cmdLst[2] = ADJUST;
  lapse.cmdLst[3] = HAPPYENDING;
}

void adjust(){
  motorReset();
  lapse.cmdLst[0] = ADJUST;
  lapse.cmdLst[1] = HAPPYENDING;
}

void motorSet(struct motor_t *motor,int direction){
 
  switch(direction){
    case FORWARD:
        motor->rpmNorm = RPMNORM;
        nxt_motor_set_speed(motor->motor,motor->speed,1);
    break;
    case STOP:
      motor->rpmNorm = 0;
      motor->speed = 0;
      nxt_motor_set_speed(motor->motor,0,1);
      break;
    case BACKWARD:
      motor->rpmNorm = RPMNORM;
      nxt_motor_set_speed(motor->motor,-(motor->speed),1);
      break;
  }
}

void adjustFUN(){
        //
        //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
        //
        if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
          motorSet(&motorRight,FORWARD);
          motorSet(&motorLeft,BACKWARD);
        }
        //
        //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
        //
        else if((lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
          motorSet(&motorRight,BACKWARD);
          motorSet(&motorLeft,FORWARD);
        }
        //
        //wenn Kontakt mit beiden Sensoren bleibe stehen
        //
        else if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight > lightVal.initRight)){
          motorSet(&motorRight,STOP);
          motorSet(&motorLeft,STOP);
          lightVal.oldLeft = lightVal.newLeft;
          lightVal.oldRight = lightVal.newRight;
          motorReset();
          lapse.cmdCnt++;
        }
        else{
          motorSet(&motorRight,FORWARD);
          motorSet(&motorLeft,FORWARD);
        }
}


void rotateFUN(int direction){
        if( motorRight.mCnt <= ROTATEVAL ){
          motorSet(&motorRight,direction*BACKWARD);
        }
        else{
          motorSet(&motorRight,STOP);
        }
        if (motorLeft.mCnt <= ROTATEVAL ){
          motorSet(&motorLeft,direction*FORWARD);
        }
        else{
          motorSet(&motorLeft,STOP);
        }
        if ( (motorRight.mCnt >= ROTATEVAL ) && (motorLeft.mCnt >= ROTATEVAL )){
          motorReset();
          lapse.cmdCnt++;
        }
}

void move_lineFUN(){
      if((lightVal.newRight < lightVal.oldRight - 30 ) || (lightVal.newLeft < lightVal.oldLeft - 30 )){
        lapse.cmdCnt++;
      }
      else{
        motorSet(&motorRight,FORWARD);
        motorSet(&motorLeft,FORWARD);
      }
}


void moveFUN(int direction, int distance){
      if((motorRight.mCnt >= distance) && (motorLeft.mCnt >= distance)){
        motorSet(&motorRight,STOP);
        motorSet(&motorLeft,STOP);
        motorReset();
        lapse.cmdCnt++;
      }
      else{
        motorSet(&motorRight,direction);
        motorSet(&motorLeft,direction);
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
  error = (motor->rpmNorm)/RPMMULTI - rpmNew;
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
  pidFUN(&motorLeft);
  pidFUN(&motorRight);
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  
  if(lapse.cmdLst[0] != 100){
    lightVal.newRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
    lightVal.newLeft = ecrobot_get_light_sensor(LIGHT_LEFT);

    switch(lapse.cmdLst[lapse.cmdCnt]){
      case ADJUST:
        adjustFUN();
        memcpy(xxxx,"ADJUST",10);
        break;

      case MOVE_B:
        moveFUN(BACKWARD,BACKWARDVAL);
        memcpy(xxxx,"MOVE_B",10);
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
        moveFUN(FORWARD,FORWARDVAL);
        memcpy(xxxx,"MOVE_F",10);
        break;

      case HAPPYENDING:
        readyFUN();
        memcpy(xxxx,"HAPPYEND",10);
        break;
    }
    
    display_clear(0);
    display_goto_xy(5,3);
    display_string(xxxx);
    display_goto_xy(0,4);
    display_int(motorLeft.rpmNew*RPMMULTI, 5);
    display_goto_xy(0,5);
    display_int(motorLeft.speed,5);
    display_goto_xy(7,4);
    display_int(motorRight.rpmNew*RPMMULTI, 5);
    display_goto_xy(7,5);
    display_int(motorRight.speed,5);
    display_update();
  }
}
