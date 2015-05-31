#ifndef _MOTOR_H_
#define _MOTOR_H_
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"

#define Q0 ( KI*TA )
#define Q1 ( KD/TA )

struct motor_t {
  U32 motor;
  EventMaskType event;
  float speed;
  int dir;
  int dis;
  float rps;
  float errorOld;
  float errorSum;
};
extern struct motor_t motorRight;
extern struct motor_t motorLeft;
#endif
