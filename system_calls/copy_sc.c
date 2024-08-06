#include <stdio.h>
#include <unistd.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    char *source = argv[1];
    char *dest = argv[2];
    char buff[120];
    int f1, f2;
    ssize_t bytesRead, bytesWritten;

    f1 = open(source, O_RDONLY);
    if(f1 == -1){
        perror("Error opening source file.");
        exit(EXIT_FAILURE);
    }

    f2 = open(dest, O_WRONLY |  O_CREAT | O_TRUNC, 0644);
    if(f2 == -1){
        perror("Error opening dest file.");
        close(f1);
        exit(EXIT_FAILURE);
    }

    while((bytesRead = read(f1, buff, sizeof(buff))) > 0 ) {
        bytesWritten = write(f2, buff, bytesRead);
        if(bytesWritten != bytesRead) {
            perror("Error Writing to destination file");
            close(f1);
            close(f2);
            exit(EXIT_FAILURE);
        }
    }
    if(bytesRead == -1){
        perror("Error reading from the file");
    }

    printf("Process Done \n");
    close(f1);
    close(f2);
    return 0;
}
