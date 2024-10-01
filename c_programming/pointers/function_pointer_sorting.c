#include <stdio.h>

int swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int compareAsc(int a, int b) {
    return a > b;
}

int compareDec(int a, int b) {
    return a < b;
}

void sort(int arr[], int n, int(*compare)(int, int)) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - 1 - i; j++) {
            if(compare(arr[j], arr[j+1])) {
                swap(&arr[j], &arr[j+1]);
            }
        }
    }
}

void printArr(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {5, 2, 9, 1, 5, 10, 1, 3};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Arr : ");
    printArr(arr, n);

    sort(arr, n, compareAsc);
    printf("Asc : ");
    printArr(arr, n);

    sort(arr, n, compareDec);
    printf("Dec : ");
    printArr(arr, n);

    return 0;
}