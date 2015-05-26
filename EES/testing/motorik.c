/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>

#define ROTATE_L  0
#define ROTATE_R  1
#define MOVE_LINE 2
#define ADJUST    3
#define MOVE_F    4
#define MOVE_B    5
#define HAPPYENDING     6

#define FORWARDVAL 600
#define BACKVAL   80
#define ROTATEVAL 475
#define INITSPEED 35 

struct rotateCnt {
  int left;
  int right;
};

struct cmd {
  int cmdLst[10];
  int cmdCnt;
};

int lightInitLeft;
int lightInitRight;
int lightValLeftOld = 0;
int lightValRightOld = 0;
int count = 0;
int lightValRight;
int lightValLeft;
int motorCountRight;
int motorCountLeft;

struct cmd lapse = { {100}, 0 };
struct rotateCnt rotateRightCnt = {ROTATEVAL, -ROTATEVAL};
struct rotateCnt rotateLeftCnt  = {-ROTATEVAL, ROTATEVAL};


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
  lapse.cmdLst[1] = ADJUST;
  lapse.cmdLst[2] = MOVE_B;
  lapse.cmdLst[3] = HAPPYENDING;
}

void adjustFUN(){
        //
        //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
        //
        if((lightValLeft > lightInitLeft) && (lightValRight < lightInitRight)){
          nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,-INITSPEED,1);
        }
        //
        //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
        //
        else if((lightValRight > lightInitRight) && (lightValLeft < lightInitLeft)){ 
          nxt_motor_set_speed(MOTOR_RIGHT,-INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
        }
        //
        //wenn Kontakt mit beiden Sensoren bleibe stehen
        //
        else if((lightValLeft > lightInitLeft) && (lightValRight > lightInitRight)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          lightValLeftOld = lightValLeft;
          lightValRightOld = lightValRight;
          lapse.cmdCnt++;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
        }
}

void move_bFUN(){
        if((motorCountRight <= -BACKVAL) && (motorCountLeft <= -BACKVAL)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);        
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          lapse.cmdCnt++;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,-INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,-INITSPEED,1);
        }
}
void rotate_rFUN(){
        if( motorCountRight > rotateRightCnt.right ){
          nxt_motor_set_speed(MOTOR_RIGHT,-45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (motorCountLeft < rotateRightCnt.left ){
          nxt_motor_set_speed(MOTOR_LEFT,45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
        if ( (motorCountRight <= rotateRightCnt.right ) && (motorCountLeft >= rotateRightCnt.left )){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          lapse.cmdCnt++;
        }
}

void rotate_lFUN(){
        if( motorCountRight < rotateLeftCnt.right ){
          nxt_motor_set_speed(MOTOR_RIGHT,45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (motorCountLeft > rotateLeftCnt.left ){
          nxt_motor_set_speed(MOTOR_LEFT,-45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
        if ( (motorCountRight >= rotateLeftCnt.right ) && (motorCountLeft <= rotateLeftCnt.left )){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          lapse.cmdCnt++;
        }
}
void move_lineFUN(){
      if((lightValRight < lightValRightOld - 30 ) || (lightValLeft < lightValLeftOld - 30 )){
        lapse.cmdCnt++;
      }
      else{
        nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
        nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
      }
}
void move_fFUN(){
      if((motorCountRight >= FORWARDVAL) && (motorCountLeft >= FORWARDVAL)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);
        lapse.cmdCnt++;
      }

      else if(motorCountRight - 4 > motorCountLeft ){
        nxt_motor_set_speed(MOTOR_RIGHT, INITSPEED - 10, 1);
        nxt_motor_set_speed(MOTOR_LEFT, INITSPEED + 5, 1);
        count = count - 1;
      }
      else if(motorCountRight + 4 < motorCountLeft ){
        nxt_motor_set_speed(MOTOR_RIGHT, INITSPEED + 10, 1);
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

void motorikTask(){
  if(lapse.cmdLst[0] != 100){
    lightValRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
    lightValLeft = ecrobot_get_light_sensor(LIGHT_LEFT);
    motorCountRight = nxt_motor_get_count(MOTOR_RIGHT);
    motorCountLeft = nxt_motor_get_count(MOTOR_LEFT);

    display_clear(0);
    display_goto_xy(5,3);
    display_int(count, 5);
    display_update();
    switch(lapse.cmdLst[lapse.cmdCnt]){
      case ADJUST:
        adjustFUN();
        break;

      case MOVE_B:
        move_bFUN();
        break;

      case ROTATE_R:
        rotate_rFUN();
        break;

      case ROTATE_L:
        rotate_lFUN();
        break;

      case MOVE_LINE:
        move_lineFUN();
        break;
        
      case MOVE_F:
        move_fFUN();
      break;

      case HAPPYENDING:
        readyFUN();
        break;
    }
  }
}

