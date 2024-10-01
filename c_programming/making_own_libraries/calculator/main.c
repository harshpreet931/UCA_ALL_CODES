#include <stdio.h>
#include "calc.h"

int main() {
    printf("Addition: %d\n", add(10, 5));
    printf("Subtraction: %d\n", subtract(10, 5));
    printf("Multiplication: %d\n", multiply(10, 5));
    printf("Division: %d\n", divide(10, 5));
    return 0;
}