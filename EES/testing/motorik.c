/************************************/
/* motorik.c für rescueFinderRobot  */
#include "nxt_config.h"
#include "ecrobot_interface.h"
#define ROTATE_L 0
#define ROTATE_R 1
#define MOVE_F   2
#define ADJUST   3
#define BACKVAL  70

/* OSEK declarations */
int lightInitLeft;
int lightInitRight;
int state = 100;
int innerState;

void moveF(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  state = MOVE_F;
}

void rotateL(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  state = ROTATE_L;
  innerState = 0;
}

void rotateR(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  state = ROTATE_R;
  innerState = 0;
}

void motorikTask(){
  int lightValRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
  int lightValLeft = ecrobot_get_light_sensor(LIGHT_LEFT);
  int motorCountRight = nxt_motor_get_count(MOTOR_RIGHT);
  int motorCountLeft = nxt_motor_get_count(MOTOR_LEFT);

  display_clear(0);
  display_goto_xy(0,0);
  display_int(state,0);
//display_goto_xy(10,0);
//display_int(,0);
  display_goto_xy(0,1);
  display_int(lightValLeft,0);
  display_goto_xy(10,1);
  display_int(lightValRight,0);
  display_goto_xy(0,2);
  display_int(motorCountLeft,0);
  display_goto_xy(10,2);
  display_int(motorCountRight,0);
  display_update();

  switch(state){
    // 
    // An Line Justieren
    //
    case ADJUST:
      //
      //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
      //
      if((lightValLeft > lightInitLeft) && (lightValRight < lightInitRight)){
        nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
      }
      //
      //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
      //
      else if((lightValRight > lightInitRight) && (lightValLeft < lightInitLeft)){ 
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
      }
      //
      //wenn Kontakt mit beiden Sensoren bleibe stehen
      //
      else if((lightValLeft > lightInitLeft) && (lightValRight > lightInitRight)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);
        state = 100;
      }
      else{
        nxt_motor_set_speed(MOTOR_RIGHT,35,1);
        nxt_motor_set_speed(MOTOR_LEFT,35,1);
      }
      break;
    //
    //90Grad nach rechts drehen, vorher um BACKVAL zurück setzen.
    //
    case ROTATE_R:
      if(innerState == 0){

        if((motorCountRight <= -BACKVAL) && (motorCountLeft <= -BACKVAL)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);        
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          innerState = 1;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
          nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        }
      }
      else{

        if( motorCountRight > -475){
          nxt_motor_set_speed(MOTOR_RIGHT,-45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (motorCountLeft < 475){
          nxt_motor_set_speed(MOTOR_LEFT,45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
        if ( (motorCountRight <= -475) && (motorCountLeft >= 475)){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          state = ADJUST;
        }
      }
      break;
    case ROTATE_L:
      if(innerState == 0){

        if((motorCountRight <= -BACKVAL) && (motorCountLeft <= -BACKVAL)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);        
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          innerState = 1;
        }
        else {
          nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
          nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        }
      }
      else{

        if( motorCountRight < 475){
          nxt_motor_set_speed(MOTOR_RIGHT,45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (motorCountLeft > -475){
          nxt_motor_set_speed(MOTOR_LEFT,-45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
        if ( (motorCountRight >= 475) && (motorCountLeft <= -475)){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          state = ADJUST;
        }
      }
      break;
    case MOVE_F:
      if((motorCountRight >= 500) && (motorCountLeft >= 500)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);

        state = ADJUST;
        break;
      }
      else{
        nxt_motor_set_speed(MOTOR_RIGHT,35,1);
        nxt_motor_set_speed(MOTOR_LEFT,35,1);
        break;
      }
  }
}

