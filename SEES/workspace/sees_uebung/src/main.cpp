#include "systemc.h"
#include "Producer.h"
#include "Consumer.h"

int sc_main(int argc, char* argv[])
{
	// generating the sc_signal
	sc_vector< sc_signal< sc_bv<1> > > up_sig,down_sig;
	up_sig.init(4);
	down_sig.init(4);
	sc_signal<int> cFloor_sig,cState_sig;
	sc_signal<bool> carry_sig;
	sc_clock clock("my_clock",0.5,SC_SEC);
	// generating the modules
	Producer prod1("Producer1");
	Consumer cons1("Consumer1");


	// connecting modules via signals
	cons1.clock(clock);
	prod1.clock(clock);
	prod1.btnUp(up_sig[1]);
	prod1.btnDown(down_sig[1]);
	cons1.upList(up_sig);
	cons1.downList(down_sig);
	cons1.cFloor(cFloor_sig);
	cons1.cState(cState_sig);
	cons1.carry(carry_sig);
	// Run the simulation till sc_stop is encountered
	sc_start();
	return 0;
}

