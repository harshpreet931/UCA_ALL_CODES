#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("fork");
        return 1;
    } else if (pid == 0) {
        printf("Child Process: PID=%d\n", getpid());
        sleep(2);  // Simulate some work in the child process
        exit(0);
    } else {
        printf("Parent Process: PID=%d\n", getpid());
        wait(NULL); // Wait for the child to finish
        printf("Child process has finished.\n");
    }

    return 0;
}

