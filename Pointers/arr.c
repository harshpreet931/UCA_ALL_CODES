#include <stdio.h>

int main() {
    int arr[] = {1, 2, 3, 4};
    int *p = arr;
    printf("%d\n", *p);
    printf("%d\n", *(p + 1));
    printf("%d\n", *(p + 2));
    printf("%d\n", *(p + 3));
    printf("%d\n", *(p + 4));
    printf("%d\n", *(p + 5));
    printf("%d\n", *(p + 6));
    return 0;
}
