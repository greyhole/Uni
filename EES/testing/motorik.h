#ifndef _MOTORIK_H_
#define _MOTORIK_H_

#include "ecrobot_interface.h"

extern int lightInitLeft;
extern int lightInitRight;
void rotateL(void); 
void rotateR(void); 
void moveF(void);
void motorikTask(void);
void adjust(void);
#endif
