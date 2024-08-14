#include <stdio.h>

void helper(int arr[]) {
    for (int num = 1; num < 100; num++) {
        int xor_result = 0;
        for (int i = 0; i < 100; i++) {
            if (arr[i] == num) {
                xor_result ^= arr[i];
            }
        }
        if (xor_result != 0) {
            printf("%d\n", num);
        }
    }
}

int abs(int num) {
    return num < 0 ? -num : num;
}

void helper2(int arr[], int n) {
    for(int i = 0; i < n; i++) {
        arr[abs(arr[i])] *= -1;
    }

    for(int i = 0; i < n; i++) {
        if(arr[i] < 0) {
            printf("%d\n", i);
        }
    }
}

int main() {
    int arr[100] = {1, 2, 1, 1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 10, 10, 11, 11,
                    12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19,
                    20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27,
                    28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35,
                    36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43,
                    44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 50, 50, 50};
    
    helper(arr);
    printf("------------------\n");
    helper2(arr, 100);

    return 0;
}
