#include <stdio.h>
#include <malloc.h>

int main(){
    int n;
    scanf("%d", &n);
    int* arr = (int*)malloc(n*sizeof(int));
    for(int i = 0; i < n; i++) scanf("%d", &arr[i]);
    
    int target;
    scanf("%d", &target);

    // sort the array (for unsorted input).
    for (int i = 0; i < n-1; i++){
        for (int j = 0; j < n-i-1; j++){
            if (arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    
    int left = 0, right = n-1;

    while(left <= right){
        int mid = left + (right - left) / 2;
        if(arr[mid] == target) {
            printf("Found \n");
            return 0;
        }
        else if(arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    printf("Not found\n");
    return 0;
}
