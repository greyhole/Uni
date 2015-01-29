#include "systemc.h"

#ifndef CONSUMER_H_
#define CONSUMER_H_
#define IDLE 0
#define UP 1
#define DOWN 2

SC_MODULE(Consumer){

	sc_out<int> cFloor,cState;
	sc_out<bool> carry;
	sc_vector< sc_in< sc_bv< 1 > > > upList,downList;
	sc_in_rv<4> request;
	int lastDirection,highDown,lowUp;
	sc_in<bool> clock,ready;

	SC_CTOR(Consumer){
		lastDirection = 2;
		upList.init(4);
		downList.init(4);
		cFloor.initialize(0);
		cState.initialize(IDLE);
		carry.initialize(false);
		SC_CTHREAD(consume,clock.pos());
	}

	void consume(){
		while(true){
			highDown = checkDown();
			lowUp = checkUp();
			cout << "consume" << endl;
			cout << "@" << sc_time_stamp() << endl;
			switch(cState){
				case IDLE:
					cout << "consume.IDLE" << endl;
					if ((highDown != -1) & (lowUp != -1)){
						if(lastDirection == 2){
							cState.write(UP);
							lastDirection = 1;
							carry.write(false);
							}
						else{
							lastDirection = 2;
							cState.write(DOWN);
							carry.write(false);
							}
					}
					else if((highDown == -1) & (lowUp != -1)){
						cout << "consume.IDLE.lowUp" << endl;
						lastDirection = 1;
						cState.write(UP);
						carry.write(false);
						}
					else if((highDown != -1) & (lowUp == -1)){
						lastDirection = 2;
						cState.write(DOWN);
						carry.write(false);
					}
					else{
						cout << "IDLE:" << cState;
					}
					wait();
					break;
				case UP:
					if(lowUp == -1){
						cState.write(IDLE);
					}
					else if(cFloor == lowUp){
						carry.write(true);
						wait(ready);
						carry.write(false);
						}
					else if(cFloor > lowUp){
						cFloor.write(cFloor-1);
						wait(4);
					}
					else{
						cFloor.write(cFloor+1);
						wait(4);
					}
					break;
				case DOWN:
					if(highDown == -1){
						cState.write(IDLE);
					}
					else if(cFloor == highDown){
						carry.write(true);
						wait(ready);
						carry.write(false);
					}
					else if(cFloor > highDown){
						cFloor.write(cFloor-1);
						wait(4);
					}
					else{
						cFloor.write(cFloor+1);
						wait(4);
					}
					break;
				}
		}
	}

	int checkUp(){
		int tmp = -1;
		for(int i(0);i < 4;i++){
			if(upList[i].read()== 1 | request[i]== 1){
				tmp = i;
			}
		}
		return tmp;
	}

	int checkDown(){
		int tmp = -1;
		for(int i(3);i >= 0 ;i--){
			if(downList[i].read() == 1 | request[i]== 1){
				tmp = i;
			}
		}
		return tmp;
	}
};

#endif
