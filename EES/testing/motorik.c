/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
#include "motorik.h"
#include <math.h>

#define ROTATE_L  0
#define ROTATE_R  1
#define MOVE_LINE 2
#define ADJUST    3
#define MOVE_F    4
#define MOVE_B    5
#define HAPPYENDING     6

#define FORWARDVAL 800
#define BACKVAL  200 
#define ROTATEVAL 465
#define INITSPEED 40 
#define TURNSPEED 45
#define ADJUSTSPEED 25

struct motorikRotate_t {
  int left;
  int right;
  int monitor;
};

struct motorikCmd_t {
  int cmdLst[10];
  int cmdCnt;
};

struct motor {
  int cntNew;
  int cntOld;
  int speed;
  int time;
  int mCnt;
  int rpmCnt;
};

int count = 0;
void *ptr;
char xxxx[10] = "BEGIN";

struct motor motorRight { 0,0,0,0,0,0 };
struct motor motorLeft { 0,0,0,0,0,0 };
struct motorikCmd_t lapse = { {100}, 0 };
struct motorikRotate_t rotateRightCnt = {ROTATEVAL, -ROTATEVAL, 0};
struct motorikRotate_t rotateLeftCnt  = {-ROTATEVAL, ROTATEVAL, 0};
struct motorikLight_t lightVal;

void moveF(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  lapse.cmdLst[0] = ADJUST;
  lapse.cmdLst[1] = MOVE_LINE;
  lapse.cmdLst[2] = MOVE_F;
  lapse.cmdLst[3] = ADJUST;
  lapse.cmdLst[4] = MOVE_B;
  lapse.cmdLst[5] = HAPPYENDING;
}


void rotateL(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  lapse.cmdLst[0] = ROTATE_L;
  lapse.cmdLst[1] = ADJUST;
  lapse.cmdLst[2] = MOVE_B;
  lapse.cmdLst[3] = HAPPYENDING;
}

void rotateR(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  lapse.cmdLst[0] = ROTATE_R;
  lapse.cmdLst[1] = ADJUST;
  lapse.cmdLst[2] = MOVE_B;
  lapse.cmdLst[3] = HAPPYENDING;
}

void adjust(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  lapse.cmdLst[0] = ADJUST;
  lapse.cmdLst[1] = MOVE_B;
  lapse.cmdLst[2] = HAPPYENDING;
}


void adjustFUN(void *data){
        if(data && ((struct motorikRotate_t *)data)->monitor){
          ((struct motorikRotate_t *)data)->right += motorStat.cntRightNew; 
          ((struct motorikRotate_t *)data)->left += motorStat.cntLeftNew;
        }
        //
        //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
        //
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);
        if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
          nxt_motor_set_speed(MOTOR_RIGHT,ADJUSTSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,-ADJUSTSPEED,1);
          ((struct motorikRotate_t *)data)->monitor = 1;
        }
        //
        //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
        //
        else if((lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
          nxt_motor_set_speed(MOTOR_RIGHT,-ADJUSTSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,ADJUSTSPEED,1);
          ((struct motorikRotate_t *)data)->monitor = 1;
        }
        //
        //wenn Kontakt mit beiden Sensoren bleibe stehen
        //
        else if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight > lightVal.initRight)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);
          lightVal.oldLeft = lightVal.newLeft;
          lightVal.oldRight = lightVal.newRight;
          ((struct motorikRotate_t *)data)->monitor = 0;
          lapse.cmdCnt++;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,ADJUSTSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,ADJUSTSPEED,1);
          ((struct motorikRotate_t *)data)->monitor = 0;
        }
}


void move_bFUN(){
        if((motorStat.cntRightNew <= -BACKVAL) && (motorStat.cntLeftNew <= -BACKVAL)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);        
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          ptr = NULL;
          lapse.cmdCnt++;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,-INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,-INITSPEED,1);
        }
}


void rotate_rFUN(){
        if( motorStat.cntRightNew > rotateRightCnt.right ){
          nxt_motor_set_speed(MOTOR_RIGHT,-TURNSPEED,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (motorStat.cntLeftNew < rotateRightCnt.left ){
          nxt_motor_set_speed(MOTOR_LEFT,TURNSPEED,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
        if ( (motorStat.cntRightNew <= rotateRightCnt.right ) && (motorStat.cntLeftNew >= rotateRightCnt.left )){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          ptr = & rotateRightCnt;
          lapse.cmdCnt++;
        }
}


void rotate_lFUN(){
        if( motorStat.cntRightNew < rotateLeftCnt.right ){
          nxt_motor_set_speed(MOTOR_RIGHT,TURNSPEED,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (motorStat.cntLeftNew > rotateLeftCnt.left ){
          nxt_motor_set_speed(MOTOR_LEFT,-TURNSPEED,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
        if ( (motorStat.cntRightNew >= rotateLeftCnt.right ) && (motorStat.cntLeftNew <= rotateLeftCnt.left )){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
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
        nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
        nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
      }
}


void move_fFUN(){
      if((motorStat.cntRightNew >= FORWARDVAL) && (motorStat.cntLeftNew >= FORWARDVAL)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);
        ptr = NULL;
        lapse.cmdCnt++;
      }
      
      else if(motorStat.cntRightNew - 1 > motorStat.cntLeftNew ){
        nxt_motor_set_speed(MOTOR_RIGHT, INITSPEED - 5, 1);
        nxt_motor_set_speed(MOTOR_LEFT, INITSPEED + 5, 1);
        count = count - 1;
      }
      else if(motorStat.cntRightNew + 1 < motorStat.cntLeftNew ){
        nxt_motor_set_speed(MOTOR_RIGHT, INITSPEED + 5, 1);
        nxt_motor_set_speed(MOTOR_LEFT, INITSPEED  - 5, 1);
        count = count + 1;
      }
      
      else{
        nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
        nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
      }
  }


void readyFUN(){
  lapse.cmdCnt = 0;
  memset(lapse.cmdLst, 100, sizeof(lapse.cmdLst));
  SetEvent(MainTask, MoveReadyEvent);
}

void rpmFUN(struct motor *data){
  tNew = systick_get_ms();
  int tmpRpm = 0;
  
  if( (*data.cntNew - 90) >= *data.cntOld ){
    *data.mCnt++;
  }

  if( *data.time == tNew ) tmpRpm = 0;
  else{
    tmpRpm = (M_PI_2*(*data.cntNew - *data.cntOld))/(tNew - *data.time);
  }
  *data.time = tNew;
  *data.rpmCnt = tmpRpm;
}
void motorikTask(){
  motorRight.cntNew = nxt_motor_get_count(MOTOR_RIGHT);
  motorLeft.cntNew = nxt_motor_get_count(MOTOR_LEFT);
  rpm(motorRight);
  rpm(motorLeft);
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
    display_update();
  }
}

