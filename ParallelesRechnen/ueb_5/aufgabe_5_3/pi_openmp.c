#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <time.h>

#include <pthread.h>

#define RNG_MOD 714025

const double pi = 3.141592653589793238462643383279;

static int pr_random(int* state)
{
    return (*state = (1366 * *state + 150889) % RNG_MOD);
}

static double pr_random_f(double range, int* state)
{
    return ((double) pr_random(state) / ((double) RNG_MOD)) * range;
}

int main(int argc, char* argv[])
{
	struct timespec time_start, time_end;
	if (clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&time_start)==-1){
		printf("Can't start Timer");
		return EXIT_FAILURE;
	}
    int i, num_threads, num_samples, hits, state;
    double error, pi_calc, x, y,erg;
    erg = 0.000;
    if (argc != 3) {
        fprintf(stderr, "usage: %s threads samples\n", argv[0]);
        return EXIT_FAILURE;
    }

    if ((num_threads = atoi(argv[1])) < 1) {
        fprintf(stderr, "invalid number of threads '%s'\n", argv[1]);
        return EXIT_FAILURE;
    }

    if ((num_samples = atoi(argv[2])) < 1) {
        fprintf(stderr, "invalid number of samples '%s'\n", argv[2]);
        return EXIT_FAILURE;
    }

    hits = 0;
    state = 0;

#pragma omp parallel for schedule(static) private (x, y) firstprivate(state) reduction(+:hits) num_threads(num_threads)
    for (i = 0; i < num_samples; i++) {
        x = pr_random_f(2.0, &state) - 1.0;
        y = pr_random_f(2.0, &state) - 1.0;
        if (x * x + y * y < 1.0) {
            hits++;
        }
    }

    pi_calc = 4.0 * hits / num_samples;
    error = (pi_calc - pi) / pi;

    printf("%d threads, x = %lf, pi = %lf, r_error = %le\n", num_threads, pi_calc, pi, error);
	if (clock_gettime(CLOCK_PROCESS_CPUTIME_ID,&time_end)==-1){
		printf("Can't start Timer");
		return EXIT_FAILURE;
	}
	erg = (time_end.tv_sec - time_start.tv_sec)*1000+((double)(time_end.tv_nsec - time_start.tv_nsec)/1000000);
    printf( "%lf\n", erg);
    return EXIT_SUCCESS;
}
