#include <stdio.h>

int main() {
    int number = 29;
    int p = 2;
    int n = 3;

    int mask = (1 << n) - 1;
    mask = mask << (p - 1);

    int result = number ^ mask;

    printf("Number after flipping %d bits from position %d is %d\n", n, p, result);

    return 0;
}