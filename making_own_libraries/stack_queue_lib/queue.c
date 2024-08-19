void push_queue(int *queue, int *rear, int value) {
    queue[++*rear] = value;
}

int pop_queue(int *queue, int *front, int rear) {
    return queue[(*front)++];
}