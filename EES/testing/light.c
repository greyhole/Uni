#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
#include "nxt_config.h"
#include "light.h"

struct motorikLight_t lightVal;

TASK(LightTask){
  lightVal.newRight = ecrobot_get_light_sensor(LIGHT_RIGHT);
  lightVal.newLeft = ecrobot_get_light_sensor(LIGHT_LEFT);

  if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight < lightVal.initRight)){
    SetEvent(MotorikTask, LightBothDown);
  }
  else if((lightVal.newRight > lightVal.initRight) && (lightVal.newLeft < lightVal.initLeft)){ 
    SetEvent(MotorikTask, LightLeftDown);
  }
  else if((lightVal.newLeft > lightVal.initLeft) && (lightVal.newRight > lightVal.initRight)){
    SetEvent(MotorikTask, LightBothDown);^
    lightVal.oldLeft = lightVal.newLeft;
    lightVal.oldRight = lightVal.newRight;
  }
  if((lightVal.newRight < lightVal.oldRight - 30 ) || (lightVal.newLeft < lightVal.oldLeft - 30 )){
    SetEvent(MotorikTask, LightBothUp);
  }
  TerminateTask();
}

