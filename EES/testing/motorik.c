/************************************/
/* motorik.c für rescueFinderRobot  */


#include "ecrobot_interface.h"
#define LIGHT_LEFT NXT_PORT_S2
#define LIGHT_RIGHT NXT_PORT_S3
#define MOTOR_LEFT NXT_PORT_B
#define MOTOR_RIGHT NXT_PORT_C
#define BACK_VAL 50
#define ROTATE_L 0
#define ROTATE_R 1
#define MOVE_F   2
#define ADJUST   3
#define BACKVAL  50

/* OSEK declarations */
int lightInitLeft;
int lightInitRight;
int state = 100;
int innerState;

function moveF(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  state = MOVE_F;;
}

function rotateL(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  state = ROTATE_L;
  innerState = 0;
}

function rotateR(){
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);
  state = ROTATE_R;
  innerState = 0;
}

function motorikTask(){
  int lightValRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
  int lightValLeft = ecrobot_get_light_sensor(LIGHT_LEFT);
  int motorCountRight = nxt_motor_get_count(MOTOR_RIGHT);
  int motorCountLeft = nxt_motor_get_count(MOTOR_LEFT);

  switch(state){
    // 
    // An Line Justieren
    //
    case ADJUST:
      //
      //wenn erst Links Kontakt des Lichtsensors dann drehe links zurück
      //
      if((lightValLeft > lightStdL) && (lightValRight < lightStdR)){
        nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        break;
      }
      //
      //wenn erst rechts Kontakt des Lichsensors dann drehe rechts zurück
      //
      else if((lightValRight > lightStdR) && (lightValLeft < lightStdL)){ 
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
        break;
      }
      //
      //wenn Kontakt mit beiden Sensoren bleibe stehen
      //
      else if((lightValLeft > lightStdL) && (lightValRight > lightStdR)){
        nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
        nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);
        fsm = 100;
        break;
      }

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
          break;
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
          nxt_motor_set_speed(MOTOR_LEFT,-35,1);
          break;
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
        if ( (motorCountRight >= -475) && (motorCountLeft <= 475){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          state = ADJUST;
      break;
      }
    case ROTATE_L:
      if(innerState == 0){

        if((motorCountRight <= -BACKVAL) && (motorCountLeft <= -BACKVAL)){
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
          nxt_motor_set_speed(MOTOR_LEFT,0,1);        
          nxt_motor_set_count(MOTOR_RIGHT, 0);
          nxt_motor_set_count(MOTOR_LEFT, 0);
          innerState = 1;
          break;
        }
        else {
          nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
          nxt_motor_set_speed(MOTOR_LEFT,-35,1);
          break;
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
        if ( (motorCountRight >= 475) && (motorCountLeft <= -475){
          nxt_motor_set_count(MOTOR_RIGHT,0);
          nxt_motor_set_count(MOTOR_LEFT,0);
          state = ADJUST;
      break;
      }
    case MOVE_F:
      if((motorCountRight >= 100) && (motorCountLeft >= 100)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);

        state = ADJUST;;
        break;
      }
      else{
        nxt_motor_set_speed(MOTOR_RIGHT,35,1);
        nxt_motor_set_speed(MOTOR_LEFT,35,1);
        break;
      }
    default:
  
  }
