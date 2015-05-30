#ifndef _MOTOR_H_
#define _MOTOR_H_
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"

#define Q0 ( KI*TA )
#define Q1 ( KD/TA )

struct motor_t {
  U32 motor;
  float speed;
  int direction;
  unsigned int mCnt;
  float rpmNorm;
  float errorOld;
  float errorSum;
};
#endif
