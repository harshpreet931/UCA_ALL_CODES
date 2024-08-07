#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    int fd = open("hello.txt", O_WRONLY | O_CREAT, 0644);
    char buffer[] = "Hello, World!";
    // write to this file
    write(fd, buffer, sizeof(buffer));
    close(fd);

    int fd = open("hello.txt", O_RDONLY);
    char buffer[128];
    // read from this file and print it to console
    write(1, buffer, read(fd, buffer, sizeof(buffer)));
    return 0;
}
