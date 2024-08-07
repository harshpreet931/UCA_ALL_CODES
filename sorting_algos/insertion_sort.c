#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <sys/time.h>
#include <assert.h>

void insertion_sort(int arr[], int n) {
    for(int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while(j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}

long long calculate_runtime(int arr[], int n){
    struct timeval before;
    gettimeofday(&before, NULL);
    long long before_millis = before.tv_sec * 1000LL + before.tv_usec / 1000;

    insertion_sort(arr, n);

    struct timeval after;
    gettimeofday(&after, NULL);
    long long after_millis = after.tv_sec * 1000LL + after.tv_usec / 1000;

    return after_millis - before_millis;
}

void test_sample_input() {
    int arr[] = {3, 1, 7, 9, 5};
    int expected_arr[] = {1, 3, 5, 7, 9};

    insertion_sort(arr, 5);
    for(int i = 0; i < 5; i++) assert(arr[i] == expected_arr[i]);
    printf("All test cases passed\n");
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
    printf("Time of sorting Arr1 : %lld ms \n", t1);
    printf("Time of soritng Arr2 : %lld ms \n", t2);
    return 0;
}
