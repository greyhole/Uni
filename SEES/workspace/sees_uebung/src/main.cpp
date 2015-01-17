#include "systemc.h"
#include "Producer.h"
#include "Consumer.h"

int sc_main(int argc, char* argv[])
{
	// generating the sc_signal
	sc_vector< sc_signal< sc_bv<1> > > up_sig,down_sig;
	up_sig.init(4);
	down_sig.init(4);
	sc_signal<int> cFloor_sig;
	// generating the modules
	Producer prod1("Producer1");
	Consumer cons1("Consumer1");


	// connecting modules via signals
	prod1.test_out(up_sig[1]);
	cons1.upList(up_sig);
	cons1.downList(down_sig);
	cons1.cFloor(cFloor_sig);
	// Run the simulation till sc_stop is encountered
	sc_start();

	return 0;
}

