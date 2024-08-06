#include <stdio.h>
#include <stdbool.h>

bool powerof2(int n){
    return (n & -n) == n;
}

bool powerof2_2(int n){
    int count = 0;
    while(n){
        count += n & 1;
        n >>= 1;
    }
    return count == 1;
}

bool powerof2_3(int n){
    return ((n & (n-1)) == 0);
}

int main() {
    int arr[] = {1, 2, 4, 8, 16, 32, 100, 200, 256, 500, 512};
    for(int i = 0; i < 11; i++){
        if(powerof2(arr[i])) printf("True_1 , %d \n", arr[i]);
        if(powerof2_2(arr[i])) printf("True_2 , %d \n", arr[i]);
        if(powerof2_3(arr[i])) printf("True_3 , %d \n \n", arr[i]);
    }
    return 0;
}