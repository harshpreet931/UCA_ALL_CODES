#include <stdio.h>

int main() {
    // This will work because str is an array of characters, which is stored in the stack
    char str[] = "Hello, World!";
    str[0] = 't';

    printf("%s\n", str);


    // This will give a segmentation fault because str2 is a string literal, which is stored in read-only memory Code segment
    char *str2 = "Hello, World!";
    str[0] = 't';

    printf("%s\n", str2);

    return 0;
}