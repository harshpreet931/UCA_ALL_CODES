#include <stdio.h>

int main() {
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        printf("Failed to open the file.\n");
        return 1;
    }

    char line[100]; // Buffer to hold the line

    // Read and print each line from the file
    while (fgets(line, sizeof(line), file) != NULL) {
        printf("Read: %s", line);
    }

    fclose(file);

    return 0;
}