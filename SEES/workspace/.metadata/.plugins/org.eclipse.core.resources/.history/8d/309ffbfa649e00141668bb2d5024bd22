#include "systemc.h"

#ifndef CONSUMER_H_
#define CONSUMER_H_
#define IDLE 0
#define UP 1
#define DOWN 2

SC_MODULE(Consumer){

	sc_out<int> cFloor,cState;
	sc_vector< sc_in< sc_bv< 1 > > > upList,downList;
	int lastDirection;

	SC_CTOR(Consumer){
		lastDirection = 2;
		upList.init(4);
		downList.init(4);
		cFloor.initialize(0);
		cState.initialize(IDLE);

		SC_METHOD(consume);

		for( uint i = 0;i<4;i++){
			sensitive << upList[i] << downList[i];
		}
	}

	void consume()
	{
		int lowDown,highUp;
		switch(cState){
		case IDLE:
			lowDown = checkDownList();
			highUp = checkUpList();
			if ((lowDown != -1) & (highUp != -1)){
				if(lastDirection == 2){
					moveTo(highUp);
				}
				else{
					moveTo()
				}
			}
			break;
		}
		cout << checkUpList() << endl;
	}

	int checkUpList(){
		int tmp = -1;
		for(uint i(cFloor);i < upList.size();i++){
			if(upList[i].read()== "1"){
				tmp = i;
			}
		}
		return tmp;
	}

	int checkDownList(){
		int tmp = -1;
		for(int i(cFloor);i >= 0 ;i--){
			if(downList[i].read() == "1"){
				tmp = i;
			}
		}
		return tmp;
	}
};

#endif
