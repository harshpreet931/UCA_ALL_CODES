#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file = fopen("strings.bin", "rb");
    int len1, len2;

    fread(&len1, sizeof(int), 1, file);

    char *str1 = (char *)malloc((len1 + 1) * sizeof(char));

    int i = 0;
    while (i < len1) {
        str1[i] = fgetc(file);
        i++;
    }
    str1[len1] = '\0';

    fread(&len2, sizeof(int), 1, file);

    char *str2 = (char *)malloc((len2 + 1) * sizeof(char));

    i = 0;
    while (i < len2) {
        str2[i] = fgetc(file);
        i++;
    }
    str2[len2] = '\0'; 

    fclose(file);

    printf("First string: %s\n", str1);
    printf("Second string: %s\n", str2);

    free(str1);
    free(str2);
    return 0;
}
