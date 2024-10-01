#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>

void exch(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}   

void quick_sort_recursive(int arr[], int left, int right) {
    if(left >= right) return;

    int pivot = arr[left];
    int i = left + 1;

    for(int j = left+1; j <= right; j++) {
        if(arr[j] < pivot) {
            exch(arr, i++, j);
        }
    }

    exch(arr, left, --i);
    quick_sort_recursive(arr, left, i-1);
    quick_sort_recursive(arr, i+1, right);
}

void quick_sort(int arr[], int n) {
    quick_sort_recursive(arr, 0, n-1);
}

long long calculate_runtime(int arr[], int n) {
    struct timeval before;
    gettimeofday(&before, NULL);
    long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

    quick_sort(arr, n);

    struct timeval after;
    gettimeofday(&after, NULL);
    long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

    return after_millis - before_millis;
}

void test_sample_input() {
    int arr[] = {3 ,1 ,7 ,9 ,5};
    int expected_output[] = {1 ,3 ,5 ,7 ,9};

    quick_sort(arr, 5);

    for(int i = 0; i < 5; i++) assert(arr[i] == expected_output[i]);
    printf("All test cases passed! \n");
}

int main() {
    test_sample_input();
    srand(time(NULL));

    int k = 32000;
    int *arr1 = (int *) malloc(sizeof(int)*k);
    for(int i = 0; i < k; i++) arr1[i] = rand();
    long long t1 = calculate_runtime(arr1, k);

    k = 64000;
    int *arr2 = (int *) malloc(sizeof(int)*k);
    for(int i = 0; i < k; i++) arr2[i] = rand();
    long long t2 = calculate_runtime(arr2, k);

    printf("%lf\n", t2*1.0 / t1);

    // worst case
    k = 32000;
    int idx = 0;
    for(int i = k-1; i >= 0; i--) arr1[idx++] = i;
    t1 = calculate_runtime(arr1, k);

    k = 64000;
    idx = 0;
    for(int i = k-1; i >= 0; i--) arr2[idx++] = i;
    t2 = calculate_runtime(arr2, k);

    printf("%lf\n", t2*1.0 / t1);
    return 0;
}