#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main() {
   int fd = open("hello.txt", O_WRONLY | O_APPEND);
   const char* message = "Bye bye! \n";
   ssize_t b_size = write(fd, message, strlen(message));
   close(fd);   
   return 0;   
}
