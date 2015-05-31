/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
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
#define RPSNORM 80


#define FORWARDVAL 970
#define BACKVAL  200 
#define ROTATEVAL 465
#define RPMMULTI 100
EventMaskType eventmask0 = 0;
EventMaskType eventmask1 = 0;

struct motorikCmd_t {
  int cmdLst[10];
  int cmdCnt;
};

char xxxx[10] = "BEGIN";
struct motorikCmd_t lapse = { {100}, 0 };


void motorSet(struct motor_t *motor,int dir, int dis, int rps){
  GetResource(MotorResource);
  motor->dir = dir;
  motor->dis = dis;
  motor->rps = rps;
  ReleaseResource(MotorResource);
}

void adjustFUN(){
int run = 1;
  while(run){
    WaitEvent(LightRightDown | LightLeftDown | LightBothDown | LightBothUp);
    GetEvent(MotorikTask, &eventmask);
    switch(eventmask){
      case LightLeftDown:
        motorSet(&motorRight,FORWARD, 0, RPSNORM);
        motorSet(&motorLeft,BACKWARD, 0, RPSNORM);
        ClearEvent(LightLeftDown);
        break;

      case LightRightDown:
        motorSet(&motorRight,BACKWARD, 0, RPSNORM);
        motorSet(&motorLeft,FORWARD, 0, RPSNORM);
        ClearEvent(LightRightDown);
        break;

      case LightBothDown:
        motorSet(&motorRight,0, 0, 0);
        motorSet(&motorLeft,0, 0, 0);
        lapse.cmdCnt++;
        run = 0;
        ClearEvent(LightBothDown);
        break;
      
      default:
        motorSet(&motorRight,FORWARD, 0, RPSNORM);
        motorSet(&motorLeft,FORWARD, 0, RPSNORM);
        ClearEvent(LightBothUp);
        break;
    }
  }
}


void moveFUN(int aktBreak){
  int run = 1;
  while(run){
    WaitEvent(MotorRight | MotorLeft);
    GetEvent(MotorikTask, &eventmask0);
    if(eventmask0 && MotorRight) ClearEvent(MotorRight);
    else ClearEvent(MotorLeft);
    eventmask1 |= eventmask0;
    if(eventmask1 && (MotorLeft | MotorRight)){
      run = 0;
      lapse.cmdCnt++;
      if(aktBreak){
        motorSet(&motorRight,0, 0, 0);
        motorSet(&motorLeft,0, 0, 0);
      }
    }
  }
}

void readyFUN(){
  lapse.cmdCnt = 0;
  memset(lapse.cmdLst, 100, sizeof(lapse.cmdLst));
  SetEvent(MainTask, MoveReadyEvent);
}


TASK(MotorikTask){
  while(true){
    WaitEvent(MoveF | RotateL | RotateR | Adjust);
    GetEvent(MotorikTask, &eventmask0);
    switch(eventmask0){
      case MoveF:
        lapse.cmdLst[0] = ADJUST;
        lapse.cmdLst[1] = MOVE_LINE;
        lapse.cmdLst[2] = MOVE_F;
        lapse.cmdLst[3] = ADJUST;
        lapse.cmdLst[4] = HAPPYENDING;
        break;
      case RotateL:
        lapse.cmdLst[0] = MOVE_B;
        lapse.cmdLst[1] = ROTATE_L;
        lapse.cmdLst[2] = ADJUST;
        lapse.cmdLst[3] = HAPPYENDING;
        break;
      case RotateR:
        lapse.cmdLst[0] = MOVE_B;
        lapse.cmdLst[1] = ROTATE_R;
        lapse.cmdLst[2] = ADJUST;
        lapse.cmdLst[3] = HAPPYENDING;
        break;
      case Adjust:
        lapse.cmdLst[0] = ADJUST;
        lapse.cmdLst[1] = HAPPYENDING;
        break;
    }
    int run = 1;
    while(run){
      if(lapse.cmdLst[0] != 100){

        switch(lapse.cmdLst[lapse.cmdCnt]){
          case ADJUST:
            motorSet(&motorRight, BACKWARD, BACKWARDVAL, RPSNORM);
            motorSet(&motorRight, BACKWARD, BACKWARDVAL, RPSNORM);
            adjustFUN();
            memcpy(xxxx,"ADJUST",10);
            break;

          case MOVE_B:
            motorSet(&motorRight, BACKWARD, BACKWARDVAL, RPSNORM);
            motorSet(&motorLeft, BACKWARD, BACKWARDVAL, RPSNORM);
            moveFUN(1);
            memcpy(xxxx,"MOVE_B",10);
            break;

          case ROTATE_R:
            motorSet(&motorRight, BACKWARD, ROTATEVAL, RPSNORM);
            motorSet(&motorLeft, FORWARD, ROTATEVAL, RPSNORM);
            moveFUN(1);
            memcpy(xxxx,"ROTATE_R",10);
            break;

          case ROTATE_L:
            motorSet(&motorRight, FORWARD, ROTATEVAL, RPSNORM);
            motorSet(&motorLeft, BACKWARD, ROTATEVAL, RPSNORM);
            moveFUN(1);
            memcpy(xxxx,"ROTATE_L",10);
            break;

          case MOVE_LINE:
            motorSet(&motorRight, FORWARD, 0, RPSNORM);
            motorSet(&motorLeft, FORWARD, 0, RPSNORM);
            WaitEvent(LightBothUp);
            lapse.cmdCnt++;
            ClearEvent(LightBothUp);
            memcpy(xxxx,"MOVE_LINE",10);
            break;
        
          case MOVE_F:
            motorSet(&motorRight, FORWARD, FORWARDVAL, RPSNORM);
            motorSet(&motorLeft, FORWARD, FORWARDVAL, RPSNORM);
            moveFUN(0);
            memcpy(xxxx,"MOVE_F",10);
            break;

          case HAPPYENDING:
            readyFUN();
            memcpy(xxxx,"HAPPYEND",10);
            break;
        }
      }
    }
  }
  TerminateTask();
}
