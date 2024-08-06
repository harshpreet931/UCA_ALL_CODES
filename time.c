#include <stdio.h>
#include <time.h>

int main(){
    clock_t start_time = clock();
    double time_used;

    int sum = 0;
    for(int i = 0; i < 100000; i++) sum += i;

    clock_t end_time = clock();
    time_used = ((double)(end_time - start_time)) / CLOCKS_PER_SEC;
    printf("CPU TIME USED: %f \n", time_used);

    return 0;
}
