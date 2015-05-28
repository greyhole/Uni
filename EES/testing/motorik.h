#ifndef _MOTORIK_H_
#define _MOTORIK_H_

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

void rotateL(void); 
void rotateR(void); 
void moveF(void);
void motorikTask(void);
void adjust(void);
#endif
