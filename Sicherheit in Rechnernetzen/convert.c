
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char phone[15];		//Sinnvolle Nummer ist bis zu 15 Zeichen lang
	int n, ok;
	while (1) {
		ok = scanf("%s",phone);
		if (strlen(phone) > 15) {
			printf(stderr, "error: number too long\n");			
			break;
		}
		if (ok==EOF) break;
		for (n=strlen(phone); n-->0;) {
			putchar(phone[n]);
			putchar(’.’);
		}
		puts("e164.arpa");
		putchar(’\n’);
	}
	return 0;
}
