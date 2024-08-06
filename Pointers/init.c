#include <stdio.h>

int main(void) {
    unsigned int a = 128;

    int *b = &a;
    char *c = &a;

    printf("%u \n", *b);
    printf("%u \n", *c);
}
