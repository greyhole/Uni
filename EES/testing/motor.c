#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
#include "nxt_config.h"
#include <math.h>
#include "motor.h"

#define TA 0.03
#define KP 10
#define KD 0
#define KI 0


struct motor_t motorRight = { MOTOR_RIGHT,0,0,0,0,0,0,0,0,0 };
struct motor_t motorLeft = { MOTOR_LEFT,0,0,0,0,0,0,0,0,0 };

void motorFUN(struct motor_t *motor){
  
  int cntNew = 0;
  float rpmNew = 0;
  float pid = 0;
  float error = 0;
  int tmp;
  
  cntNew = abs(nxt_motor_get_count(motor->motor));
  tmp = motor->mCnt - cntNew;
  
  if(tmp > 0){
    motor->mCnt = tmp;
  }
  else{
    if(motor->motor == MOTOR_RIGHT){
      SetEvent(MotorCtrl,MotorRightEvent);
      return;
    }
    else{
      SetEvent(MotorCtrl,MotorLeftEvent);
      return;
    }
  }
  rpmNew = (cntNew / (360*TA));
  error = (motor->rpmNorm) - rpmNew;
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
  nxt_motor_set_speed(motor->motor,motor->direction * motor->speed,1);
  nxt_motor_set_count(motor->motor, 0);
}

Task(MotorTask){
  GetResource(MotorResource);
  motorFUN(&motorLeft);
  motorFUN(&motorRight);
  ReleaseResource(MotorResource);
}

