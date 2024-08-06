#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int* arr = NULL;
int N = 0;
int max_size = 1;

int size() {
    return N;
}

bool isEmpty() {
    return N == 0;
}

void resize(int new_size) {
    int* new_arr = (int *) malloc(new_size * sizeof(int));
    for(int i = 0; i < N; i++) {
        new_arr[i] = arr[i];
    }

    free(arr);
    arr = new_arr;
    max_size = new_size;
}

void push(int item) {
    if(arr == NULL) {
        arr = (int*) malloc(max_size * sizeof(int));
    } else if(N == max_size) {
        resize(2 * max_size);
        max_size *= 2;
    }
    arr[N++] = item;
}

int pop() {
    if(isEmpty()) return INT_MIN;
    int item = arr[--N];
    if(N > 0 && N == max_size / 4) {
        resize(max_size / 2);
        max_size /= 2;
    } 
    return item;
}

void testStack() {
    push(3);
    push(10);
    push(20);

    assert(isEmpty() == false);
    assert(size() == 3);
    assert(pop() == 20);
    assert(size() == 2);
    assert(pop() == 10);
    assert(size() == 1);
    assert(pop() == 3);
    assert(size() == 0);
    assert(isEmpty());

    free(arr);
}

int main() {
    testStack();
    printf("All tests passed.\n");
    return 0;
}
