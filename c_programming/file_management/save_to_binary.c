#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char str1[] = "Hello";
    char str2[] = "World";
    
    FILE *file = fopen("strings.bin", "wb");

    int len1 = strlen(str1);
    int len2 = strlen(str2);

    fwrite(&len1, sizeof(int), 1, file); 
    fwrite(str1, sizeof(char), len1, file); 
    fwrite(&len2, sizeof(int), 1, file); 
    fwrite(str2, sizeof(char), len2, file);
    fclose(file);

    return 0;
}
