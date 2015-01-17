#include <systemc.h>

#ifndef PRODUCER_H_
#define PRODUCER_H_

SC_MODULE(Producer){

	sc_out< sc_bv<1> > test_out;
	int i;

	SC_CTOR(Producer){
		i = 0;
		test_out.initialize(0);
		SC_THREAD(produce);
	}

	void produce()
	{
		i = 0;
		while(i < 10) {
			test_out.write(i);
			wait(SC_ZERO_TIME); //sonst kommt der Consumer nie dran
			i++;
		}
	}

};

#endif

 

