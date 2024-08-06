#include <stdio.h>

int main(void) {
    unsigned int a =6235342340;

    int *b = &a;
    char *c = &a;

    printf("%d\n", *b);
    printf("%d\n", *c);
}