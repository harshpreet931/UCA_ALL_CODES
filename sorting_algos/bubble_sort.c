#include <stdio.h>
#include <malloc.h>
#include <assert.h>
#include <time.h>
#include <sys/time.h>
#include <stdlib.h>

void bubble_sort(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n-i-1; j++) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

long long calculate_runtime(int arr[], int n) {
    struct timeval before;
    gettimeofday(&before, NULL);
    long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

    bubble_sort(arr, n);

    struct timeval after;
    gettimeofday(&after, NULL);
    long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

    return after_millis - before_millis;
}

void test_sample_input() {
    int arr[] = {3, 1, 7, 9, 5};
    int expected_arr[] = {1, 3, 5, 7, 9};
    
    bubble_sort(arr, 5);
    for(int i = 0; i < 5; i++) assert(arr[i] == expected_arr[i]);
}

int main() {
    test_sample_input();
    srand(time(NULL));

    int k = 3200;
    int *arr1 = (int *) malloc(sizeof(int)*k);
    for(int i = 0; i < k; i++) arr1[i] = rand();
    long long t1 = calculate_runtime(arr1, k);

    k = 6400;
    int *arr2 = (int *) malloc(sizeof(int)*k);
    for(int i = 0; i < k; i++) arr2[i] = rand();
    long long t2 = calculate_runtime(arr2, k);

    printf("%lf\n", t2*1.0 / t1);
    return 0;
}
