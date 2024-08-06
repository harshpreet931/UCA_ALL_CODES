#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(){
    int fd = open("hello.txt", O_CREAT | O_WRONLY, 0644);
    const char * message = "Hello world! This is going to write to the file!! \n";
    ssize_t b_size = write(fd, message, strlen(message));
    close(fd);
    return 0;
}
