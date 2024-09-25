#include <stdio.h>

int main() {
    char input[100]; // Allocate space for the input

    printf("Enter a string: ");
    if (fgets(input, sizeof(input), stdin) != NULL) {
        printf("You entered: %s", input);
    } else {
        printf("An error occurred while reading input.\n");
    }

    return 0;
}