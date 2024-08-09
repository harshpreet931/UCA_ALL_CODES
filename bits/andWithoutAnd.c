#include <stdio.h>

int helper(int a, int b) {
    return ~(~a | ~b);
}

int main() {
    printf("%d\n", helper(5, 10));
    printf("%d\n", helper(7, 4));
    printf("%d\n", helper(2, 15));
    return 0;
}