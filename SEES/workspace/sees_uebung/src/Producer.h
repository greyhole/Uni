#include <systemc.h>

#ifndef PRODUCER_H_
#define PRODUCER_H_

SC_MODULE(Producer){

	sc_out< sc_bv<1> > btnUp,btnDown;
	sc_in<bool> clock;
	SC_CTOR(Producer){
		btnUp.initialize(0);
		btnDown.initialize(0);
		SC_CTHREAD(produce,clock.pos());
	}

	void produce()
	{
		while(true) {
			btnUp.write(1);
			btnDown.write(0);
			wait(4);
			btnUp.write(0);
			btnDown.write(1);
			wait(4);
			btnUp.write(0);
			btnDown.write(0);
			wait(4);
			btnUp.write(1);
			btnDown.write(1);
			wait(4);
			sc_stop();
		}
	}

};

#endif

 

