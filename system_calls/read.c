#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int fd, sz;
    char *c = (char *)calloc(100, sizeof(char));

    if (c == NULL) {
        perror("Memory allocation failed");
        exit(1);
    }

    fd = open("foo.txt", O_RDONLY);
    if (fd < 0) {
        perror("Error opening file");
        free(c);
        exit(1);
    }

    sz = read(fd, c, 10);
    if (sz < 0) {
        perror("Error reading file");
        close(fd);
        free(c);
        exit(1);
    }

    printf("Called read(%d, c, 10). Returned that %d bytes were read.\n", fd, sz);
    c[sz] = '\0';
    printf("Those bytes are as follows: %s\n", c);

    close(fd);
    free(c);
    return 0;
}
