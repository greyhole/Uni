/************************************/
/* motorik.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
#include "motorik.h"

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


int count = 0;
int motorCountRight;
int motorCountLeft;
void *ptr;

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
  lapse.cmdLst[1] = ADJUST;
  lapse.cmdLst[2] = MOVE_B;
  lapse.cmdLst[3] = HAPPYENDING;
}


void adjustFUN(void *data){
        if(data && ((struct motorikRotate_t *)data)->monitor){
          ((struct motorikRotate_t *)data)->right += motorCountRight; 
          ((struct motorikRotate_t *)data)->left += motorCountLeft;
        }
        //
        //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
        //
        if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
          nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,-INITSPEED,1);
          ((struct motorikRotate_t *)data)->monitor = 1;
        }
        //
        //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
        //
        else if((lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
          nxt_motor_set_speed(MOTOR_RIGHT,-INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
          ((struct motorikRotate_t *)data)->monitor = 1;
        }
        //
        //wenn Kontakt mit beiden Sensoren bleibe stehen
        //
        else if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight > lightVal.initRight)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          lightVal.oldLeft = lightVal.newLeft;
          lightVal.oldRight = lightVal.newRight;
          ((struct motorikRotate_t *)data)->monitor = 0;
          lapse.cmdCnt++;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,INITSPEED,1);
          nxt_motor_set_speed(MOTOR_LEFT,INITSPEED,1);
          ((struct motorikRotate_t *)data)->monitor = 0;
        }
}


void move_bFUN(){
        if((motorCountRight <= -BACKVAL) && (motorCountLeft <= -BACKVAL)){
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
          ptr = & rotateRightCnt;
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
      if((motorCountRight >= FORWARDVAL) && (motorCountLeft >= FORWARDVAL)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);
        ptr = NULL;
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
    lightVal.newRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
    lightVal.newLeft = ecrobot_get_light_sensor(LIGHT_LEFT);
    motorCountRight = nxt_motor_get_count(MOTOR_RIGHT);
    motorCountLeft = nxt_motor_get_count(MOTOR_LEFT);

    display_clear(0);
    display_goto_xy(5,3);
    display_int(count, 5);
    display_update();
    switch(lapse.cmdLst[lapse.cmdCnt]){
      case ADJUST:
        adjustFUN(ptr);
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

