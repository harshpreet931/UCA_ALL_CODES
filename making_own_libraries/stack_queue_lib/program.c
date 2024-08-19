#include <stdio.h>
#include "functions.h"

#define MAX_SIZE 100

int main() {
    int stack[MAX_SIZE];
    int stack_top = -1;

    int queue[MAX_SIZE];
    int queue_front = 0;
    int queue_rear = 0;
    int queue_size = 0;

    push_stack(stack, &stack_top, 10);
    push_stack(stack, &stack_top, 20);
    printf("Popped from stack: %d\n", pop_stack(stack, &stack_top));

    push_queue(queue, &queue_rear, &queue_size, 30);
    push_queue(queue, &queue_rear, &queue_size, 40);
    printf("Popped from queue: %d\n", pop_queue(queue, &queue_front, &queue_size));

    return 0;
}
