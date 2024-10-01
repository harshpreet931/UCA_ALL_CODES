#include <stdio.h>

int compl(int n)
{
    int mask = -1;
    while(n & mask) mask <<= 1;
    return ~mask & ~n;
}

int main()
{
    int n = 5;
    int res = compl(n);
    printf("Complement of %d is %d\n", n, res);
}