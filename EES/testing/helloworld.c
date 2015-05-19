/* rms.c */
#include "kernel.h"
#include "kernel_id.h"
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

/* OSEK declarations */
DeclareCounter(SysTimerCnt);
DeclareTask(Task1);
DeclareTask(TaskLCD);
int lightStdR,lightStdL,fsm=3;

/* nxtOSEK hooks */
void ecrobot_device_initialize(void)
{
  ecrobot_set_light_sensor_active(LIGHT_RIGHT); //right
  ecrobot_set_light_sensor_active(LIGHT_LEFT); //left 
  nxt_motor_set_speed(MOTOR_LEFT, 0, 1);
  nxt_motor_set_speed(MOTOR_RIGHT, 0, 1);
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);

  lightStdR = ecrobot_get_light_sensor(LIGHT_RIGHT) + 30;
  lightStdL = ecrobot_get_light_sensor(LIGHT_LEFT) + 30;
}

void ecrobot_device_terminate(void)
{
  ecrobot_set_light_sensor_inactive(LIGHT_RIGHT); //right
  ecrobot_set_light_sensor_inactive(LIGHT_LEFT); //left
  nxt_motor_set_speed(MOTOR_LEFT, 0, 1);
  nxt_motor_set_speed(MOTOR_RIGHT, 0, 1);
}

/* nxtOSEK hook to be invoked from an ISR in category 2 */
void user_1ms_isr_type2(void)
{
  StatusType ercd;

  ercd = SignalCounter(SysTimerCnt); /* Increment OSEK Alarm Counter */
  if (ercd != E_OK)
  {
    ShutdownOS(ercd);
  }
}

/* Task1 executed every 1msec */
TASK(Task1){
      int lightValR = ecrobot_get_light_sensor(LIGHT_RIGHT);
      int lightValL = ecrobot_get_light_sensor(LIGHT_LEFT);
      int motorValR = nxt_motor_get_count(MOTOR_RIGHT);
      int motorValL = nxt_motor_get_count(MOTOR_LEFT);

  switch(fsm){

    // 
    // An Line Justieren
    //
    case ADJUST:
      if((lightValL > lightStdL) && (lightValR < lightStdR)){
        nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
      }
      else if((lightValR > lightStdR) && (lightValL < lightStdL)){ 
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
      }
      else if((lightValL > lightStdL) && (lightValR > lightStdR)){
        nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
        nxt_motor_set_speed(MOTOR_LEFT,-35,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);

        fsm = 1;
      }
      else{
        nxt_motor_set_speed(MOTOR_RIGHT,35,1);
        nxt_motor_set_speed(MOTOR_LEFT,35,1);
      }
      break;


    case ROTATE_R:
      if((motorValR == 0) && (motorValL == 0)){
        nxt_motor_set_speed(MOTOR_RIGHT,-35,1);
        nxt_motor_set_speed(MOTOR_LEFT,-35,1);        
      }
      else if((motorValR <= -BACK_VAL) && (motorValL <= -BACK_VAL)){
        if( -475 - BACK_VAL <= motorValR){
          nxt_motor_set_speed(MOTOR_RIGHT,-45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        }
        if (475 - BACK_VAL >= motorValL){
          nxt_motor_set_speed(MOTOR_LEFT,45,1);
        }
        else{
          nxt_motor_set_speed(MOTOR_LEFT,0,1); 
        }
      }
      break;
    case 2:
      if((motorValR == 0) && (motorValL == 0)){
        nxt_motor_set_speed(MOTOR_RIGHT,35,1);
        nxt_motor_set_speed(MOTOR_LEFT,35,1);

      }else if((motorValR >= 100) && (motorValL >= 100)){
        nxt_motor_set_speed(MOTOR_RIGHT,0,1);
        nxt_motor_set_speed(MOTOR_LEFT,0,1);
        nxt_motor_set_count(MOTOR_LEFT, 0);
        nxt_motor_set_count(MOTOR_RIGHT, 0);

        fsm = 0;
      }
      break;
    default:
  
  }

  display_clear(0);

  display_goto_xy(0,0);
  display_int(lightStdL,0);
  display_goto_xy(10,0);
  display_int(lightStdR,0);


  display_goto_xy(0,1);
  display_int(lightValL,0);
  display_goto_xy(10,1);
  display_int(lightValR,0);

  display_goto_xy(0,3);
  display_int(motorValL,0);
  display_goto_xy(10,3);
  display_int(motorValR,0);


  display_update();  
  TerminateTask();
}