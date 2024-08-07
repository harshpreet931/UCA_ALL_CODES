#include <stdio.h>
#include <fcntl.h>
#include <errno.h>
#include <unistd.h>

extern int errno;

int main() {
    // Attempt to open the file foo.txt in read-only mode, creating it if it does not exist
    int fd = open("foo.txt", O_RDONLY | O_CREAT);
    printf("fd = %d \n", fd);
    
    if (fd == -1) {
        printf("Error Number: %d \n", errno);
        perror("Program");
    }

    if (fd != -1) {
        close(fd);
    }
    
    return 0;
}
