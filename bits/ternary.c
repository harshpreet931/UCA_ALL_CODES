#include <stdio.h>

int ternary(int cond, int e1, int e2) {
    int mask = -cond;
    return (mask & e1) | (~mask & e2);
}

int main() {
    int cond1 = 1;
    int cond2 = 0;
    int e1 = 20;
    int e2 = 40;

    printf("%d\n", ternary(cond1, e1, e2));
    printf("%d\n", ternary(cond2, e1, e2));
    return 0;  
}
