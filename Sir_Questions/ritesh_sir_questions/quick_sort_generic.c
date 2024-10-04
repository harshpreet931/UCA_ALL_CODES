#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void exch(void* arr, int a, int b, size_t size)
{
    void* temp = malloc(size), *eleA = (char*) arr + a*size, *eleB = (char*) arr + b*size;
    memcpy(temp, eleA, size);
    memcpy(eleA, eleB, size);
    memcpy(eleB, temp, size);
    free(temp);
}

void quick_sort(void* arr, int left, int right, size_t size, int (*cmp)(void*, void*))
{
    if(left >= right) return;

    void* pivot = (char*) arr + left*size;
    int i = left + 1;

    for(int j = left + 1; j <= right; j++)
    {
        void* ele = (char*) arr + j*size;
        if(cmp(ele, pivot) < 0) exch(arr, i++, j, size);
    }

    exch(arr, left, --i, size);
    quick_sort(arr, left, i-1, size, cmp);
    quick_sort(arr, i+1, right, size, cmp);
}

int compareInt(void* a, void* b) { return *(int*) a - *(int*) b; }
int compareFloat(void* a, void* b) { return *(float*) a - *(float*) b; }
int compareDouble(void* a, void* b) { return *(double*) a - *(double*) b; }
int compareChar(void* a, void* b) { return *(char*) a - *(char*) b; }
int compareLong(void* a, void* b) { return *(long*) a - *(long*) b; }
int compareLongLong(void* a, void* b) { return *(long long*) a - *(long long*) b; }
int compareString(void* a, void* b) { return strcmp(*(char**) a, *(char**) b); }

int main()
{
    char* arr[] = {"banana", "apple", "grape", "cherry", "orange"};
    int n = 5;
    quick_sort(arr, 0, n-1, sizeof(char*), compareString);
    for(int i = 0; i < n; i++) printf("%s ", arr[i]);
    printf("\n");

    int arr1[] = {3, 1, 7, 9, 5};
    n = 5;
    quick_sort(arr1, 0, n-1, sizeof(int), compareInt);
    for(int i = 0; i < n; i++) printf("%d ", arr1[i]);
    printf("\n");

    float arr2[] = {3.0, 1.0, 7.0, 9.0, 5.0};
    n = 5;
    quick_sort(arr2, 0, n-1, sizeof(float), compareFloat);
    for(int i = 0; i < n; i++) printf("%.2f ", arr2[i]);
    printf("\n");

    double arr3[] = {3.0, 1.0, 7.0, 9.0, 5.0};
    n = 5;
    quick_sort(arr3, 0, n-1, sizeof(double), compareDouble);
    for(int i = 0; i < n; i++) printf("%.2lf ", arr3[i]);
    printf("\n");

    char arr4[] = {'c', 'a', 'g', 'i', 'e'};
    n = 5;
    quick_sort(arr4, 0, n-1, sizeof(char), compareChar);
    for(int i = 0; i < n; i++) printf("%c ", arr4[i]);
    printf("\n");
}