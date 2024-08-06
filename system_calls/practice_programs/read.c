#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    int fd = open("hello.txt", O_RDONLY);
    char buffer[128];
    ssize_t b_size;
    while((b_size = read(fd, buffer, sizeof(buffer)-1)) > 0) {
        buffer[b_size] = '\0';
        printf("%s", buffer);
    }
    close(fd);
    return 0;
}
