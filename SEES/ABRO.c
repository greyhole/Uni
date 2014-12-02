/* sscc : C CODE OF SORTED EQUATIONS ABRO - INLINE MODE */

/* AUXILIARY DECLARATIONS */

#ifndef STRLEN
#define STRLEN 81
#endif
#define _COND(A,B,C) ((A)?(B):(C))
#ifdef TRACE_ACTION
#include <stdio.h>
#endif
#ifndef NULL
#define NULL ((char*)0)
#endif

#ifndef __EXEC_STATUS_H_LOADED
#define __EXEC_STATUS_H_LOADED

typedef struct {
unsigned int start:1;
unsigned int kill:1;
unsigned int active:1;
unsigned int suspended:1;
unsigned int prev_active:1;
unsigned int prev_suspended:1;
unsigned int exec_index;
unsigned int task_exec_index;
void (*pStart)();
void (*pRet)();
} __ExecStatus;

#endif
#define __ResetExecStatus(status) {\
   status.prev_active = status.active; \
   status.prev_suspended = status.suspended; \
   status.start = status.kill = status.active = status.suspended = 0; }
#define __DSZ(V) (--(V)<=0)
#define BASIC_TYPES_DEFINED
typedef int boolean;
typedef int integer;
typedef char* string;
#define _true 1
#define _false 0
#define __ABRO_GENERIC_TEST(TEST) return TEST;
typedef void (*__ABRO_APF)();
static __ABRO_APF *__ABRO_PActionArray;

                  
/* EXTERN DECLARATIONS */

#ifndef _NO_EXTERN_DEFINITIONS
#endif

/* INITIALIZED CONSTANTS */

/* MEMORY ALLOCATION */

static boolean __ABRO_V0;
static boolean __ABRO_V1;
static boolean __ABRO_V2;


/* INPUT FUNCTIONS */

void ABRO_I_A () {
__ABRO_V0 = _true;
}
void ABRO_I_B () {
__ABRO_V1 = _true;
}
void ABRO_I_R () {
__ABRO_V2 = _true;
}

/* ACTIONS */

/* PREDEFINED ACTIONS */

/* PRESENT SIGNAL TESTS */

#define __ABRO_A1 \
__ABRO_V0
#define __ABRO_A2 \
__ABRO_V1
#define __ABRO_A3 \
__ABRO_V2

/* OUTPUT ACTIONS */

#define __ABRO_A4 \
ABRO_O_O()

/* ASSIGNMENTS */

#define __ABRO_A5 \
__ABRO_V0 = _false
#define __ABRO_A6 \
__ABRO_V1 = _false
#define __ABRO_A7 \
__ABRO_V2 = _false

/* PROCEDURE CALLS */

/* CONDITIONS */

/* DECREMENTS */

/* START ACTIONS */

/* KILL ACTIONS */

/* SUSPEND ACTIONS */

/* ACTIVATE ACTIONS */

/* WRITE ARGS ACTIONS */

/* RESET ACTIONS */

/* ACTION SEQUENCES */

/* FUNCTIONS RETURNING NUMBER OF EXEC */

int ABRO_number_of_execs () {
return (0);
}


/* AUTOMATON (STATE ACTION-TREES) */



static void __ABRO__reset_input () {
__ABRO_V0 = _false;
__ABRO_V1 = _false;
__ABRO_V2 = _false;
}

/* REDEFINABLE BIT TYPE */

#ifndef __SSC_BIT_TYPE_DEFINED
typedef char __SSC_BIT_TYPE;
#endif

/* REGISTER VARIABLES */

static __SSC_BIT_TYPE __ABRO_R[4] = {_true,
 _false,
 _false,
 _false};

/* AUTOMATON ENGINE */

int ABRO () {
/* AUXILIARY VARIABLES */

static __SSC_BIT_TYPE E[8];
E[0] = __ABRO_R[1]||__ABRO_R[2];
E[1] = (__ABRO_R[3]||E[0])&&!(__ABRO_R[0]);
E[2] = E[1]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 3\n"),
#endif
__ABRO_A3));
E[3] = __ABRO_R[1]&&E[2];
E[4] = E[3]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 1\n"),
#endif
__ABRO_A1);
E[5] = __ABRO_R[2]&&E[2];
E[6] = E[5]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 2\n"),
#endif
__ABRO_A2);
E[7] = (E[0]&&!(__ABRO_R[1]))||E[4];
E[0] = (E[0]&&!(__ABRO_R[2]))||E[6];
E[6] = (E[4]||E[6])&&E[7]&&E[0];
if (E[6]) {
__ABRO_A4;
#ifdef TRACE_ACTION
fprintf(stderr, "__ABRO_A4\n");
#endif
}
E[4] = !(_true);
E[1] = E[1]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 3\n"),
#endif
__ABRO_A3);
E[1] = E[1]||__ABRO_R[0];
E[3] = E[3]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 1\n"),
#endif
__ABRO_A1));
__ABRO_R[1] = E[1]||(__ABRO_R[1]&&E[3]);
E[5] = E[5]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 2\n"),
#endif
__ABRO_A2));
__ABRO_R[2] = E[1]||(__ABRO_R[2]&&E[5]);
__ABRO_R[3] = E[6]||(__ABRO_R[3]&&E[2]);
E[0] = ((__ABRO_R[1]||__ABRO_R[2])&&(E[7]||__ABRO_R[1])&&(E[0]||__ABRO_R[2]))||__ABRO_R[3];
__ABRO_R[0] = !(_true);
__ABRO__reset_input();
return E[0];
}

/* AUTOMATON RESET */

int ABRO_reset () {
__ABRO_R[0] = _true;
__ABRO_R[1] = _false;
__ABRO_R[2] = _false;
__ABRO_R[3] = _false;
__ABRO__reset_input();
return 0;
}
