#include <stdio.h>
#include <stdlib.h>

void* custom_calloc(int num, int size) {
    void *ptr = malloc(num * size);

    for(int i = 0; i < num*size; i++) {
        *((char *)ptr + i) = '\0';
    }

    return ptr;
}

int main() {
    int *ptr = (int *)custom_calloc(5, sizeof(int));

    for(int i = 0; i < 5; i++) {
        printf("%d ", *(ptr + i));
    }

    free(ptr);
}