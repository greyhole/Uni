#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "nxt_config.h"
#include "motor.h"

#define TA 0.03
#define KP 10
#define KD 0
#define KI 0


struct motor_t motorRight = { MOTOR_RIGHT,0,0,0,0,0,0,0 };
struct motor_t motorLeft = { MOTOR_LEFT,0,0,0,0,0,0,0 };

void motorFUN(struct motor_t *motor){
  
  int cntNew = 0;
  float rpsNew = 0;
  float pid = 0;
  float error = 0;
  int tmp = 0;
  cntNew = abs(nxt_motor_get_count(motor->motor));
  tmp = motor->dis - cntNew;
  if(tmp > 0){
    motor->dis = tmp;
  }
  else if(motor->dis){
    if(motor->aktBreak){
      motor->rps = 0;
      motor->dir = 0;
      motor->dis = 0;
    }
  }

  rpsNew = (cntNew / (360*TA));
  error = (motor->rps) - rpsNew;
  (motor->errorSum) += error;
  pid = (KP * error) + (Q0 * (motor->errorSum)) + (Q1 * (error - (motor->errorOld)));
  (motor->errorOld) = error;
  
  if( pid > 3 ){
    motor->speed += 3;
  }
  else if( pid < -3){
    (motor->speed) -= -3;
  }
  else{
    (motor->speed) += pid;
  }
  nxt_motor_set_speed(motor->motor,motor->dir * motor->speed,1);
  nxt_motor_set_count(motor->motor, 0);
}

TASK(MotorTask){
  GetResource(MotorResource);
  motorFUN(&motorLeft);
  motorFUN(&motorRight);
  if((motorRight.dis <= 0) && (motorLeft.dis <= 0)){
    SetEvent(MotorikTask, MotorStopped);
  }
  ReleaseResource(MotorResource);
  TerminateTask();
}

