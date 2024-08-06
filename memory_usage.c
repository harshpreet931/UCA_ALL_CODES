#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>

int main(){
    struct rusage usage_start;
    getrusage(RUSAGE_SELF, &usage_start);

    int *arr = (int *)malloc(10000 * sizeof(int));
    for(int i = 0; i < 10000; i++) arr[i] = i;

    struct rusage usage_end;
    getrusage(RUSAGE_SELF, &usage_end);

    long memory_used = usage_end.ru_maxrss - usage_start.ru_maxrss;
    printf("Memory Used: %ld KB \n", memory_used);
    
    free(arr);
    return 0;
}
