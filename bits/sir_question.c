#include <stdio.h>

int f(int x){
    int sign = x >> 31;
    int mask = ((x | ~x + 1) >> 31) & 1;
    return sign | mask;
}

int f2(int x){
    return x >> 31 | !!x;
}

int main() {
    int n = -5, n2 = 0, n3 = 5;
    printf("%d %d %d\n",f(n), f(n2), f(n3));
    printf("%d %d %d\n",f2(n), f2(n2), f2(n3));
    return 0;
}
