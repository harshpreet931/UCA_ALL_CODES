#include <stdio.h>
#include <assert.h>
#include <time.h>
#include <sys/time.h>
#include <stdlib.h>

void merge(int arr[], int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[n1], R[n2];

    for(i = 0; i < n1; i++) L[i] = arr[l + i];
    for(j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

    i = 0; j = 0; k = l;

    while(i < n1 && j < n2) {
        if(L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while(i < n1) {
        arr[k] = L[i];
        i++; k++;
    }
    while(j < n2) {
        arr[k] = R[j];
        j++; k++;
    }
}

void merge_sort(int arr[], int l, int r) {
    if(l < r) {
        int m = l + (r - l) / 2;
        
        merge_sort(arr, l, m);
        merge_sort(arr, m + 1, r);

        merge(arr, l, m, r);
    } 
}

long long calculate_runtime(int arr[], int n){
    struct timeval before;
    gettimeofday(&before, NULL);
    long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

    merge_sort(arr, 0, n-1);

    struct timeval after;
    gettimeofday(&after, NULL);
    long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

    return after_millis - before_millis;
}

void initialize_ascending(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        arr[i] = i;
    }
}

void initialize_descending(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        arr[i] = n - i;
    }
}



int main() {
    srand(time(NULL));
    int k = 320000;
    int* arr = (int *)malloc(k * sizeof(int));
    int* arr2 = (int *)malloc(2 * k * sizeof(int));
    int* arr3 = (int *)malloc(3 * k * sizeof(int));
    int* arr4 = (int *)malloc(4 * k * sizeof(int));
    int* arr5 = (int *)malloc(5 * k * sizeof(int));
    int* arr6 = (int *)malloc(6 * k * sizeof(int));

    for(int i = 0; i < k; i++) arr[i] = rand();
    for(int i = 0; i < 2 * k; i++) arr2[i] = rand();
    for(int i = 0; i < 3 * k; i++) arr3[i] = rand();
    for(int i = 0; i < 4 * k; i++) arr4[i] = rand();
    for(int i = 0; i < 5 * k; i++) arr5[i] = rand();
    for(int i = 0; i < 6 * k; i++) arr6[i] = rand();

    printf("Random Initialization : \n");
    printf("%lld\n", calculate_runtime(arr, k));
    printf("%lld\n", calculate_runtime(arr2, 2 * k));
    printf("%lld\n", calculate_runtime(arr3, 3 * k));
    printf("%lld\n", calculate_runtime(arr4, 4 * k));
    printf("%lld\n", calculate_runtime(arr5, 5 * k));
    printf("%lld\n", calculate_runtime(arr6, 6 * k));

    initialize_ascending(arr, k);
    initialize_ascending(arr2, 2 * k);
    initialize_ascending(arr3, 3 * k);
    initialize_ascending(arr4, 4 * k);
    initialize_ascending(arr5, 5 * k);
    initialize_ascending(arr6, 6 * k);

    printf("Ascending Order:\n");
    printf("%lld\n", calculate_runtime(arr, k));
    printf("%lld\n", calculate_runtime(arr2, 2 * k));
    printf("%lld\n", calculate_runtime(arr3, 3 * k));
    printf("%lld\n", calculate_runtime(arr4, 4 * k));
    printf("%lld\n", calculate_runtime(arr5, 5 * k));
    printf("%lld\n", calculate_runtime(arr6, 6 * k));

    initialize_descending(arr, k);
    initialize_descending(arr2, 2 * k);
    initialize_descending(arr3, 3 * k);
    initialize_descending(arr4, 4 * k);
    initialize_descending(arr5, 5 * k);
    initialize_descending(arr6, 6 * k);

    printf("Descending Order:\n");
    printf("%lld\n", calculate_runtime(arr, k));
    printf("%lld\n", calculate_runtime(arr2, 2 * k));
    printf("%lld\n", calculate_runtime(arr3, 3 * k));
    printf("%lld\n", calculate_runtime(arr4, 4 * k));
    printf("%lld\n", calculate_runtime(arr5, 5 * k));
    printf("%lld\n", calculate_runtime(arr6, 6 * k));

    free(arr);
    free(arr2);
    free(arr3);
    free(arr4);
    free(arr5);
    free(arr6);
    return 0;
}
