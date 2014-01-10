CC=gcc
CFLAGS=-Wall -Wextra -ltr

all: pi_openmp pi_pthread

pi_openmp: pi_openmp.c
	$(CC) $(CFLAGS) -fopenmp $^ -o $@

pi_pthread: pi_pthread.c
	$(CC) $(CFLAGS) -pthread $^ -o $@

.PHONY: clean

clean: 
	rm -f pi_openmp pi_pthread
