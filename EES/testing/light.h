#ifndef _MOTOR_H_
#define _MOTOR_H_
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"

struct motorikLight_t {
  int initLeft;
  int initRight;
  int newLeft;
  int newRight;
  int oldLeft;
  int oldRight;
};

extern struct motorikLight_t lightVal;
#endif
