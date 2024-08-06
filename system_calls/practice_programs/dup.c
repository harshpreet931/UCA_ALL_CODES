#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    int fd = open("hello.txt", O_RDONLY);
    int fd_dup = dup(fd);
    printf("Original FD: %d, Duplicated FD: %d \n", fd, fd_dup);
    close(fd);
    close(fd_dup);
    return 0;
}
