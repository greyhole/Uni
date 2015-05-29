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

#define ROTATE_L  0
#define ROTATE_R  1
#define MOVE_LINE 2
#define ADJUST    3
#define MOVE_F    4
#define MOVE_B    5
#define HAPPYENDING     6

#define MBOTH 10
#define MRIGHT 11
#define MLEFT 12

#define TA 0.5
#define KP 10
#define KD 0
#define KI 0

#define FORWARDVAL 30000
#define BACKVAL  200 
#define ROTATEVAL 465
#define INITSPEED 40 
#define TURNSPEED 45
#define ADJUSTSPEED 25
#define RPMMULTI 100
struct motorikRotate_t {
  int left;
  int right;
  int monitor;
};

struct motorikCmd_t {
  int cmdLst[10];
  int cmdCnt;
};

struct motor_t {
  int cntNew;
  int speed;
  int time;
  unsigned int mCnt;
  float rpmCnt;
  float rpmCntStd;
  float rpmPid;
  float errorOld;
  float errorSum;
};

int count = 0;
void *ptr;
char xxxx[10] = "BEGIN";

struct motor_t motorRight = { 0,0,0,0,0,0,0,0,0 };
struct motor_t motorLeft = { 0,0,0,0,0,0,0,0,0 };
struct motorikCmd_t lapse = { {100}, 0 };
struct motorikRotate_t rotateRightCnt = {ROTATEVAL, -ROTATEVAL, 0};
struct motorikRotate_t rotateLeftCnt  = {-ROTATEVAL, ROTATEVAL, 0};
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
  lapse.cmdLst[4] = MOVE_B;
  lapse.cmdLst[5] = HAPPYENDING;
}


void rotateL(){
  motorReset();
  lapse.cmdLst[0] = ROTATE_L;
  lapse.cmdLst[1] = ADJUST;
  lapse.cmdLst[2] = MOVE_B;
  lapse.cmdLst[3] = HAPPYENDING;
}

void rotateR(){
  motorReset();
  lapse.cmdLst[0] = ROTATE_R;
  lapse.cmdLst[1] = ADJUST;
  lapse.cmdLst[2] = MOVE_B;
  lapse.cmdLst[3] = HAPPYENDING;
}

void adjust(){
  motorReset();
  lapse.cmdLst[0] = ADJUST;
  lapse.cmdLst[1] = MOVE_B;
  lapse.cmdLst[2] = HAPPYENDING;
}

void motorSet(int data,int opt){
  
  switch(data){
    case MBOTH:
      if(opt){
        motorRight.rpmCntStd = motorLeft.rpmCntStd = 70;
      }
      else{
        motorRight.rpmCntStd = motorLeft.rpmCntStd = 0;
        motorRight.speed = motorLeft.speed = 0;
      }    
    break;
    case MRIGHT:
      if(opt){
        motorRight.rpmCntStd = 70;
      }
      else{
        motorRight.rpmCntStd = 0;
        motorRight.speed = 0;
      }    
      break;
    case MLEFT:
      if(opt){
        motorLeft.rpmCntStd = 70;
      }
      else{
        motorLeft.rpmCntStd = 0;
        motorLeft.speed = 0;
      }    
      break;
  }
}

void adjustFUN(void *data){
     /*   if(data && ((struct motorikRotate_t *)data)->monitor){
          ((struct motorikRotate_t *)data)->right += motorRight.mCnt; 
          ((struct motorikRotate_t *)data)->left += motorLeft.mCnt;
        }*/
        //
        //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
        //
        if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
          motorSet(MBOTH,1);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
          nxt_motor_set_speed(MOTOR_LEFT,-motorLeft.speed,1);
          //((struct motorikRotate_t *)data)->monitor = 1;
        }
        //
        //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
        //
        else if((lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
          motorSet(MBOTH,1);
          nxt_motor_set_speed(MOTOR_RIGHT,-motorRight.speed,1);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);
          //((struct motorikRotate_t *)data)->monitor = 1;
        }
        //
        //wenn Kontakt mit beiden Sensoren bleibe stehen
        //
        else if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight > lightVal.initRight)){
          motorSet(MBOTH,0);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);        
          lightVal.oldLeft = lightVal.newLeft;
          lightVal.oldRight = lightVal.newRight;
          //((struct motorikRotate_t *)data)->monitor = 0;
          motorReset();
          lapse.cmdCnt++;
        }
        else{
          motorSet(MBOTH,1);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);        
          //((struct motorikRotate_t *)data)->monitor = 0;
        }
}


void move_bFUN(){
        if((motorRight.mCnt >= BACKVAL) && (motorLeft.mCnt >= BACKVAL)){
          motorSet(MBOTH,0);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);        
          motorReset();
          ptr = NULL;
          lapse.cmdCnt++;
        }
        else{
          motorSet(MBOTH,1);
          nxt_motor_set_speed(MOTOR_RIGHT,-motorRight.speed,1);
          nxt_motor_set_speed(MOTOR_LEFT,-motorRight.speed,1);
        }
}


void rotate_rFUN(){
        if( motorRight.mCnt <= rotateRightCnt.right ){
          motorSet(MRIGHT,1);
          nxt_motor_set_speed(MOTOR_RIGHT,-motorRight.speed,1);
        }
        else{
          motorSet(MRIGHT,0);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
        }
        if (motorLeft.mCnt <= rotateRightCnt.left ){
          motorSet(MLEFT,1);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);
        }
        else{
          motorSet(MLEFT,0);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1); 
        }
        if ( (motorRight.mCnt >= rotateRightCnt.right ) && (motorLeft.mCnt >= rotateRightCnt.left )){
          motorReset();
          ptr = & rotateRightCnt;
          lapse.cmdCnt++;
        }
}


void rotate_lFUN(){
        if( motorRight.mCnt <= rotateLeftCnt.right ){
          motorSet(MRIGHT,1);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
        }
        else{
          motorSet(MRIGHT,0);
          nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
        }
        if (motorLeft.mCnt <= rotateLeftCnt.left ){
          motorSet(MLEFT,1);
          nxt_motor_set_speed(MOTOR_LEFT,-motorLeft.speed,1);
        }
        else{
          motorSet(MLEFT,0);
          nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1); 
        }
        if ( (motorRight.mCnt <= rotateLeftCnt.right ) && (motorLeft.mCnt <= rotateLeftCnt.left )){
          motorReset();
          ptr = &rotateLeftCnt;
          lapse.cmdCnt++;
        }
}


void move_lineFUN(){
      if((lightVal.newRight < lightVal.oldRight - 30 ) || (lightVal.newLeft < lightVal.oldLeft - 30 )){
        ptr = NULL;
        lapse.cmdCnt++;
      }
      else{
        motorSet(MBOTH,1);
        nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
        nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);
      }
}


void move_fFUN(){
      if((motorRight.mCnt >= FORWARDVAL) && (motorLeft.mCnt >= FORWARDVAL)){
        motorSet(MBOTH,0);
        nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
        nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);
        motorReset();
        ptr = NULL;
        lapse.cmdCnt++;
      }
     /* 
      else if(motorRight.mCnt - 1 > motorLeft.mCnt ){
        nxt_motor_set_speed(MOTOR_RIGHT, INITSPEED - 5, 1);
        nxt_motor_set_speed(MOTOR_LEFT, INITSPEED + 5, 1);
        count = count - 1;
      }
      else if(motorRight.mCnt + 1 < motorLeft.mCnt ){
        nxt_motor_set_speed(MOTOR_RIGHT, INITSPEED + 5, 1);
        nxt_motor_set_speed(MOTOR_LEFT, INITSPEED  - 5, 1);
        count = count + 1;
      }
      */
      else{
        motorSet(MBOTH,1);
        nxt_motor_set_speed(MOTOR_RIGHT,motorRight.speed,1);
        nxt_motor_set_speed(MOTOR_LEFT,motorLeft.speed,1);
      }
  }


void readyFUN(){
  lapse.cmdCnt = 0;
  memset(lapse.cmdLst, 100, sizeof(lapse.cmdLst));
  SetEvent(MainTask, MoveReadyEvent);
}

void rpmFUN(struct motor_t *data){
  data->mCnt += data->cntNew;
  data->rpmCnt = ((data->cntNew) / (360*TA));
}


void pidFUN(struct motor_t *data){
  float error = (data->rpmCntStd)/RPMMULTI - (data->rpmCnt);
  (data->errorSum) += error;
  (data->rpmPid) = (KP * error) + (Q0 * (data->errorSum)) + (Q1 * (error - (data->errorOld)));
  (data->errorOld) = error;
  if( data->rpmPid > 15){
    data->speed += 30;
  }
  else{
  (data->speed) += (data->rpmPid);
  }
}

void motorikTask(){
  motorRight.cntNew = abs(nxt_motor_get_count(MOTOR_RIGHT));
  motorLeft.cntNew = abs(nxt_motor_get_count(MOTOR_LEFT));
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  rpmFUN(&motorRight);
  rpmFUN(&motorLeft);
  pidFUN(&motorLeft);
  pidFUN(&motorRight);
  /*display_clear(0);
  display_goto_xy(0,2);
  display_int(motorLeft.mCnt,5);
  display_update();
  */
  if(lapse.cmdLst[0] != 100){
    lightVal.newRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
    lightVal.newLeft = ecrobot_get_light_sensor(LIGHT_LEFT);

    switch(lapse.cmdLst[lapse.cmdCnt]){
      case ADJUST:
        adjustFUN(ptr);
        memcpy(xxxx,"ADJUST",10);
        break;

      case MOVE_B:
        move_bFUN();
        memcpy(xxxx,"MOVE_B",10);
        break;

      case ROTATE_R:
        rotate_rFUN();
         memcpy(xxxx,"ROTATE_R",10);
        break;

      case ROTATE_L:
        rotate_lFUN();
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
    display_goto_xy(0,0);
    display_int(rotateRightCnt.left, 3);
    display_goto_xy(0,1);
    display_int(rotateRightCnt.right, 3);
    display_goto_xy(5,3);
    display_string(xxxx);
    display_goto_xy(0,4);
    display_int(motorLeft.rpmCnt*RPMMULTI*10, 5);
    display_goto_xy(0,5);
    display_int(motorLeft.speed,5);
    display_goto_xy(7,4);
    display_int(motorRight.rpmCnt*RPMMULTI*10, 5);
    display_goto_xy(7,5);
    display_int(motorRight.speed,5);
    display_update();
  }
}

