/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
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
#define RPSNORM 70


#define FORWARDVAL 900
#define BACKWARDVAL  200 
#define ROTATEVAL 450
#define RPSMULTI 100
EventMaskType eventmask0 = 0;
EventMaskType eventmask1 = 0;

struct motorikCmd_t {
  int cmdLst[10];
  int cmdCnt;
};

char xxxx[10] = "BEGIN";
struct motorikCmd_t lapse = { {100}, 0 };


void motorSet(struct motor_t *motor,int dir, int dis, float rps, int aktBreak){
  GetResource(MotorResource);
  motor->dir = dir;
  motor->dis = dis;
  motor->rps = rps/RPSMULTI;
  motor->aktBreak = aktBreak;
  ReleaseResource(MotorResource);
}
void resetEvents(){
  eventmask0 = 0;
  ClearEvent(MotorStopped);
  ClearEvent(LightRightDown);
  ClearEvent(LightLeftDown);
  ClearEvent(LightBothDown);
  ClearEvent(LightBothUp);
  ClearEvent(MoveF);
  ClearEvent(Adjust);
  ClearEvent(RotateL);
  ClearEvent(RotateR);
}

void adjustFUN(){
  int run = 1;
  while(run){
    resetEvents();
    WaitEvent(LightRightDown | LightLeftDown | LightBothDown | LightBothUp);
    GetEvent(MotorikTask, &eventmask0);
    if((eventmask0 & LightLeftDown) && !(eventmask0 & LightRightDown)){
        motorSet(&motorRight,FORWARD, 0, RPSNORM/2,0);
        motorSet(&motorLeft,BACKWARD, 0, RPSNORM/2,0);
    }
    else if((eventmask0 & LightRightDown) && !(eventmask0 & LightLeftDown)){
        motorSet(&motorRight,BACKWARD, 0, RPSNORM/2,0);
        motorSet(&motorLeft,FORWARD, 0, RPSNORM/2,0);
    }
    else if(eventmask0 & LightBothDown){
        motorSet(&motorRight,0, 0, 0,1);
        motorSet(&motorLeft,0, 0, 0,1);
        run = 0;
    }
    else{
        motorSet(&motorRight,FORWARD, 0, RPSNORM/2,0);
        motorSet(&motorLeft,FORWARD, 0, RPSNORM/2,0);
    }
  }
}


void moveFUN(int safe){
  int err;
  int run = 1;
  while(run){
    resetEvents();
    eventmask0 = 0;
    WaitEvent( MotorStopped | LightRightDown | LightLeftDown);
    GetEvent(MotorikTask, &eventmask0);
    if(safe){
      if(eventmask0 & LightRightDown){
        err = motorRight.dis;
        motorSet(&motorLeft, 0, 0, 0, 1);
        motorSet(&motorRight, BACKWARD, 530, RPSNORM*1.5, 1);
        moveFUN(0);
         
        motorSet(&motorRight, 0, 0, 0, 1);
        motorSet(&motorLeft, BACKWARD, 555, RPSNORM*1.5, 1);
        moveFUN(0);
        
        if(err > 2*FORWARDVAL/3){
        motorSet(&motorRight, FORWARD, 350, RPSNORM, 1);
        motorSet(&motorLeft, FORWARD, 350, RPSNORM, 1);
        moveFUN(0);
        }
        run = 0;
      }
      else if(eventmask0 & LightLeftDown){
        err = motorLeft.dis;
        motorSet(&motorRight, 0, 0, 0, 1);
        motorSet(&motorLeft, BACKWARD, 530, RPSNORM*1.5, 1);
        moveFUN(0);
         
        motorSet(&motorLeft, 0, 0, 0, 1);
        motorSet(&motorRight, BACKWARD, 555, RPSNORM*1.5, 1);
        moveFUN(0);
      
        if(err > 2*FORWARDVAL/3){
        motorSet(&motorRight, FORWARD, 350, RPSNORM, 1);
        motorSet(&motorLeft, FORWARD, 350, RPSNORM, 1);
        moveFUN(0);
        }
        run = 0;
      }
    }
   if(eventmask0 & MotorStopped){
      run = 0;
    }
  }
}

TASK(MotorikTask){
  while(true){
    //resetEvents();
    WaitEvent(MoveF | RotateL | RotateR | Adjust);
    GetEvent(MotorikTask, &eventmask0);
    
    if(eventmask0 & MoveF){
        lapse.cmdLst[0] = MOVE_LINE;
        lapse.cmdLst[1] = MOVE_F;
        lapse.cmdLst[2] = ADJUST;
        lapse.cmdLst[3] = HAPPYENDING;
    }
    else if(eventmask0 & RotateL){
        lapse.cmdLst[0] = MOVE_B;
        lapse.cmdLst[1] = ROTATE_L;
        lapse.cmdLst[2] = ADJUST;
        lapse.cmdLst[3] = HAPPYENDING;
    }
    else if(eventmask0 & RotateR){
        lapse.cmdLst[0] = MOVE_B;
        lapse.cmdLst[1] = ROTATE_R;
        lapse.cmdLst[2] = ADJUST;
        lapse.cmdLst[3] = HAPPYENDING;
    }
    else if(eventmask0 & Adjust){
        lapse.cmdLst[0] = ADJUST;
        lapse.cmdLst[1] = HAPPYENDING;
    }
    //resetEvents();
    int run = 1;
    while(run){
      if(lapse.cmdLst[0] != 100){

        switch(lapse.cmdLst[lapse.cmdCnt]){
          case ADJUST:
            memcpy(xxxx,"ADJUST",10);
            display_clear(0);
            display_goto_xy(0,0);
            display_string(xxxx);
            display_update();
            motorSet(&motorRight, FORWARD, 0, RPSNORM, 1);
            motorSet(&motorLeft, FORWARD, 0, RPSNORM, 1);
            adjustFUN();
            lapse.cmdCnt++;
            break;

          case MOVE_B:
            memcpy(xxxx,"MOVE_B",10);
            display_clear(0);
            display_goto_xy(0,0);
            display_string(xxxx);
            display_update();
            motorSet(&motorRight, BACKWARD, BACKWARDVAL, RPSNORM, 1);
            motorSet(&motorLeft, BACKWARD, BACKWARDVAL, RPSNORM, 1);
            moveFUN(0);
            lapse.cmdCnt++;
            break;

          case ROTATE_R:
            motorSet(&motorRight, BACKWARD, ROTATEVAL, RPSNORM, 1);
            motorSet(&motorLeft, FORWARD, ROTATEVAL, RPSNORM, 1);
            moveFUN(0);
            lapse.cmdCnt++;
            break;

          case ROTATE_L:
            motorSet(&motorRight, FORWARD, ROTATEVAL, RPSNORM, 1);
            motorSet(&motorLeft, BACKWARD, ROTATEVAL, RPSNORM, 1);
            moveFUN(0);
            lapse.cmdCnt++;
            break;

          case MOVE_LINE:
            motorSet(&motorRight, FORWARD, 0, RPSNORM, 0);
            motorSet(&motorLeft, FORWARD, 0, RPSNORM, 0);
            resetEvents();
            WaitEvent(LightBothUp);
            lapse.cmdCnt++;
            ClearEvent(LightBothUp);
            memcpy(xxxx,"MOVE_LINE",10);
            break;
        
          case MOVE_F:
            memcpy(xxxx,"MOVE_F",10);
            display_clear(0);
            display_goto_xy(0,0);
            display_string(xxxx);
            display_update();
            motorSet(&motorRight, FORWARD, FORWARDVAL, RPSNORM,1);
            motorSet(&motorLeft, FORWARD, FORWARDVAL, RPSNORM,1);
            moveFUN(1);
            lapse.cmdCnt++;
            break;

          case HAPPYENDING:
            memcpy(xxxx,"HAPPY",10);
            display_clear(0);
            display_goto_xy(0,0);
            display_string(xxxx);
            display_update();
            run = 0;
            lapse.cmdCnt = 0;
            memset(lapse.cmdLst, 100, sizeof(lapse.cmdLst));
            SetEvent(MainTask, MoveReadyEvent);
            break;
        }
      }
    }
  }
  TerminateTask();
}
