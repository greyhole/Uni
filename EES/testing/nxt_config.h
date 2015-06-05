/**
 *  *******************************************************************************
 *   ** FILE NAME : nxt_config.h
 *    **
 *     ** ABSTRUCT : NXT device configration
 *      *******************************************************************************
 *       **/

#ifndef _NXT_CONFIG_H_
#define _NXT_CONFIG_H_
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
/* NXT motor port configuration */
#define MOTOR_LEFT NXT_PORT_B
#define MOTOR_RIGHT NXT_PORT_C
/* NXT sensor port configuration */
#define LIGHT_LEFT NXT_PORT_S2
#define LIGHT_RIGHT NXT_PORT_S3
#define SOUND NXT_PORT_S1
#define SONAR NXT_PORT_S4

DeclareCounter(SysTimerCnt);
DeclareCounter(BtTimer);
DeclareTask(MainTask);
DeclareTask(MotorikTask);
DeclareTask(MotorTask);
DeclareTask(LightTask);
DeclareTask(UpdateStatus);
DeclareTask(FetchBtPackage);
DeclareTask(DecodeBtPackage);
DeclareTask(SonarTask);
DeclareTask(LCDTask);

DeclareEvent(PackageReceivedEvent);
DeclareEvent(MoveReadyEvent);
DeclareEvent(MotorStopped);

DeclareEvent(LightLeftDown);
DeclareEvent(LightRightDown);
DeclareEvent(LightBothDown);
DeclareEvent(LightBothUp);

DeclareEvent(MoveF);
DeclareEvent(RotateL);
DeclareEvent(RotateR);
DeclareEvent(Adjust);

DeclareResource(MotorResource);
#endif
