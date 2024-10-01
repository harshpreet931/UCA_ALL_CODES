#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <limits.h>
#include <time.h>

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int low, int high) {
    int pivot_index = low + rand() % (high - low + 1);
    swap(&arr[pivot_index], &arr[high]);
    int pivot = arr[high];

    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quick_sort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quick_sort(arr, low, pi - 1);
        quick_sort(arr, pi + 1, high);
    }
}

long long current_time_millis() {
    struct timeval time;
    gettimeofday(&time, NULL);
    return time.tv_sec * 1000LL + time.tv_usec / 1000;
}

long long calculate_runtime(int arr[], int n) {
    long long start_time = current_time_millis();
    quick_sort(arr, 0, n - 1);
    long long end_time = current_time_millis();
    return end_time - start_time;
}

void initialize_ascending(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        arr[i] = i;
    }
}

void initialize_descending(int arr[], int n) {
    for (int i = 0; i < n; i++) {
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

    for (int i = 0; i < k; i++) arr[i] = rand();
    for (int i = 0; i < 2 * k; i++) arr2[i] = rand();
    for (int i = 0; i < 3 * k; i++) arr3[i] = rand();
    for (int i = 0; i < 4 * k; i++) arr4[i] = rand();
    for (int i = 0; i < 5 * k; i++) arr5[i] = rand();
    for (int i = 0; i < 6 * k; i++) arr6[i] = rand();

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

