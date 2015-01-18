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
	int lastDirection;
	sc_in<bool> clock;

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
			cout << "consume" << endl;
			int lowDown,highUp;
			cout << "@" << sc_time_stamp() << endl;
			switch(cState){
				case IDLE:
					cout << "consume.IDLE" << endl;
					lowDown = checkDownList();
					highUp = checkUpList();
					if ((lowDown != -1) & (highUp != -1)){
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
					else if((lowDown == -1) & (highUp != -1)){
						cout << "consume.IDLE.highUp" << endl;
						lastDirection = 1;
						cState.write(UP);
						carry.write(false);
					}
					else if((lowDown != -1) & (highUp == -1)){
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
					cout << "UP:" << cState << endl;
					cState.write(IDLE);
					wait();
					break;
				case DOWN:
					cout << "DOWN:" << cState << endl;
					cState.write(IDLE);
					wait();
					break;
				}
		}
	}

	int checkUpList(){
		int tmp = -1;
		for(uint i(0);i < upList.size();i++){
			if(upList[i].read()== "1"){
				tmp = i;
			}
		}
		return tmp;
	}

	int checkDownList(){
		int tmp = -1;
		for(int i(3);i >= 0 ;i--){
			if(downList[i].read() == "1"){
				tmp = i;
			}
		}
		return tmp;
	}
};

#endif
