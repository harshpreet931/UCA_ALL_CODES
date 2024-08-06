#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(){
    int fd = open("temp.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
    
    int sz = write(fd, "Hello World \n", strlen("Hello World \n"));
    
    close(fd);

    fd = open("temp.txt", O_RDONLY);
    char buffer[100];
    int bytesRead = read(fd, buffer, sizeof(buffer));
    write(1, buffer, bytesRead);
    
    close(fd);
    return 0;
}
