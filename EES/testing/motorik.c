/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
#include "motorik.h"
#include <stdlib.h>
#include <stdio.h>
#include "motor.h"

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


#define FORWARDVAL 970
#define BACKVAL  200 
#define ROTATEVAL 465
#define RPMMULTI 100



char xxxx[10] = "BEGIN";
struct motorikCmd_t lapse = { {100}, 0 };

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


void move_bFUN(){
        if((motorRight.mCnt >= BACKVAL) && (motorLeft.mCnt >= BACKVAL)){
          motorSet(&motorRight,STOP);
          motorSet(&motorLeft,STOP);
          motorReset();
          lapse.cmdCnt++;
        }
        else{
          motorSet(&motorRight,BACKWARD);
          motorSet(&motorLeft,BACKWARD);
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


void move_fFUN(){
      if((motorRight.mCnt >= FORWARDVAL) && (motorLeft.mCnt >= FORWARDVAL)){
        motorSet(&motorRight,STOP);
        motorSet(&motorLeft,STOP);
        motorReset();
        lapse.cmdCnt++;
      }
      else{
        motorSet(&motorRight,FORWARD);
        motorSet(&motorLeft,FORWARD);
      }
  }


void readyFUN(){
  lapse.cmdCnt = 0;
  memset(lapse.cmdLst, 100, sizeof(lapse.cmdLst));
  SetEvent(MainTask, MoveReadyEvent);
}


Task(MotorikTask){
  while(true)

  if(lapse.cmdLst[0] != 100){
    lightVal.newRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
    lightVal.newLeft = ecrobot_get_light_sensor(LIGHT_LEFT);

    switch(lapse.cmdLst[lapse.cmdCnt]){
      case ADJUST:
        adjustFUN();
        memcpy(xxxx,"ADJUST",10);
        break;

      case MOVE_B:
        move_bFUN();
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
        move_fFUN();
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
