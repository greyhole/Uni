/************************************/
/* sensoric.c für rescueFinderRobot  */
#include "kernel.h"
#include "kernel_id.h"
#include "nxt_config.h"
#include "ecrobot_interface.h"
#include <string.h>
#define BUFFERCOUNT 16
#define BUFFERMASK (BUFFERCOUNT-1)

/* OSEK declarations */

U8 sonarBuffer[BUFFERCOUNT];
int sonarSumme;
U8 sonarMittel;
U8 bufferPointer;
int minSound=1023;
int sound;


int getSound(){

	int sound = ecrobot_get_sound_sensor(SOUND);
	if (sound < minSound) {
	minSound = sound;	
	}
	return minSound;
}


void setSound(){
	minSound=1023;
}

void initSonar(){
memset(sonarBuffer,255,BUFFERCOUNT);
sonarSumme = 4080;
sonarMittel = 255;
bufferPointer = 0;
}

TASK (SonarTask) {
    U8 sonarWert = ecrobot_get_sonar_sensor(SONAR);
    sonarSumme -= sonarBuffer[bufferPointer];
    sonarBuffer[bufferPointer] = sonarWert;
    sonarSumme += sonarBuffer[bufferPointer];
    bufferPointer++;
    bufferPointer = bufferPointer & BUFFERMASK;
    sonarMittel = sonarSumme / BUFFERCOUNT;


TerminateTask();
}




 
