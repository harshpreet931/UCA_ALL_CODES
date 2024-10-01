#include <stdio.h>

int logical_not(int x) {
    return ((x | -x) >> 31) + 1;
}

int main() {
    printf("%d\n", logical_not(0)); 
    printf("%d\n", logical_not(1)); 
    printf("%d\n", logical_not(-1));
    printf("%d\n", logical_not(100));
    printf("%d\n", logical_not(-100));
    printf("%d\n", logical_not(logical_not(0))); 
    return 0;
}