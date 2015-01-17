/* sscc : C CODE OF SORTED EQUATIONS TP - INLINE MODE */

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
#define __TP_GENERIC_TEST(TEST) return TEST;
typedef void (*__TP_APF)();
static __TP_APF *__TP_PActionArray;

                     
/* EXTERN DECLARATIONS */

#ifndef _NO_EXTERN_DEFINITIONS
#endif

/* INITIALIZED CONSTANTS */

/* MEMORY ALLOCATION */

static boolean __TP_V0;
static boolean __TP_V1;
static boolean __TP_V2;
static boolean __TP_V3;


/* INPUT FUNCTIONS */

void TP_I_GO () {
__TP_V0 = _true;
}
void TP_I_STOP () {
__TP_V1 = _true;
}
void TP_I_FRONT () {
__TP_V2 = _true;
}
void TP_I_BACK () {
__TP_V3 = _true;
}

/* ACTIONS */

/* PREDEFINED ACTIONS */

/* PRESENT SIGNAL TESTS */

#define __TP_A1 \
__TP_V0
#define __TP_A2 \
__TP_V1
#define __TP_A3 \
__TP_V2
#define __TP_A4 \
__TP_V3

/* OUTPUT ACTIONS */

#define __TP_A5 \
TP_O_FORWARD()
#define __TP_A6 \
TP_O_BACKWARD()
#define __TP_A7 \
TP_O_HALT()

/* ASSIGNMENTS */

#define __TP_A8 \
__TP_V0 = _false
#define __TP_A9 \
__TP_V1 = _false
#define __TP_A10 \
__TP_V2 = _false
#define __TP_A11 \
__TP_V3 = _false

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

int TP_number_of_execs () {
return (0);
}


/* AUTOMATON (STATE ACTION-TREES) */



static void __TP__reset_input () {
__TP_V0 = _false;
__TP_V1 = _false;
__TP_V2 = _false;
__TP_V3 = _false;
}

/* REDEFINABLE BIT TYPE */

#ifndef __SSC_BIT_TYPE_DEFINED
typedef char __SSC_BIT_TYPE;
#endif

/* REGISTER VARIABLES */

static __SSC_BIT_TYPE __TP_R[3] = {_true,
 _false,
 _false};

/* AUTOMATON ENGINE */

int TP () {
/* AUXILIARY VARIABLES */

static __SSC_BIT_TYPE E[9];
E[0] = __TP_R[1]&&!(__TP_R[0]);
E[1] = E[0]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 1\n"),
#endif
__TP_A1);
E[2] = __TP_R[2]&&!(__TP_R[0]);
E[3] = E[2]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 2\n"),
#endif
__TP_A2));
E[3] = __TP_R[2]&&E[3];
E[4] = E[3]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 3\n"),
#endif
__TP_A3));
E[5] = E[4]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 4\n"),
#endif
__TP_A4);
if (E[1]||E[5]) {
__TP_A5;
#ifdef TRACE_ACTION
fprintf(stderr, "__TP_A5\n");
#endif
}
E[3] = E[3]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 3\n"),
#endif
__TP_A3);
if (E[3]) {
__TP_A6;
#ifdef TRACE_ACTION
fprintf(stderr, "__TP_A6\n");
#endif
}
E[6] = E[1]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 2\n"),
#endif
__TP_A2);
E[2] = E[2]&&(
#ifdef TRACE_ACTION
fprintf(stderr, "test 2\n"),
#endif
__TP_A2);
E[2] = E[6]||E[2]||E[3]||E[5];
if (E[2]) {
__TP_A7;
#ifdef TRACE_ACTION
fprintf(stderr, "__TP_A7\n");
#endif
}
E[6] = !(_true);
E[0] = E[0]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 1\n"),
#endif
__TP_A1));
E[0] = __TP_R[0]||E[2]||(__TP_R[1]&&E[0]);
E[7] = E[1]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 2\n"),
#endif
__TP_A2));
E[4] = E[4]&&!((
#ifdef TRACE_ACTION
fprintf(stderr, "test 4\n"),
#endif
__TP_A4));
E[4] = E[7]||(__TP_R[2]&&E[4]);
E[7] = E[0]||E[4];
E[8] = __TP_R[1]||__TP_R[2];
__TP_R[0] = !(_true);
__TP_R[1] = E[0];
__TP_R[2] = E[4];
__TP__reset_input();
return E[7];
}

/* AUTOMATON RESET */

int TP_reset () {
__TP_R[0] = _true;
__TP_R[1] = _false;
__TP_R[2] = _false;
__TP__reset_input();
return 0;
}
