/* rms.c */
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
#include "nxt_config.h"
#include "motorik.h"

/* OSEK declarations */
//DeclareEvent(MoveReadyEvent);
/* nxtOSEK hooks */
void ecrobot_device_initialize(void)
{
  ecrobot_set_light_sensor_active(LIGHT_RIGHT); //right
  ecrobot_set_light_sensor_active(LIGHT_LEFT); //left 
  nxt_motor_set_speed(MOTOR_LEFT, 0, 1);
  nxt_motor_set_speed(MOTOR_RIGHT, 0, 1);
  nxt_motor_set_count(MOTOR_LEFT, 0);
  nxt_motor_set_count(MOTOR_RIGHT, 0);

  lightVal.initRight = ecrobot_get_light_sensor(LIGHT_RIGHT) + 30;
  lightVal.initLeft = ecrobot_get_light_sensor(LIGHT_LEFT) + 30;
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
TASK(MotorikTask){
  motorikTask();
  TerminateTask();
}

TASK(MainTask){
  adjust();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);

  while(1){
  moveF();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  moveF();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  moveF();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  moveF();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  moveF();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  rotateL();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  moveF();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  rotateL();
  WaitEvent(MoveReadyEvent);
  ClearEvent(MoveReadyEvent);
  }
  TerminateTask();
}
