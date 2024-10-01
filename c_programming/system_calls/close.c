#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    // Attempt to open the file foo.txt in read-only mode
    int fd1 = open("foo.txt", O_RDONLY);
    if (fd1 < 0) {
        perror("Error opening file");
        exit(1);
    }
    printf("Opened the file descriptor: %d\n", fd1);

    // Attempt to close the file descriptor
    if (close(fd1) < 0) {
        perror("Error closing file");
        exit(1);
    }
    printf("Closed the file descriptor.\n");

    return 0;
}
