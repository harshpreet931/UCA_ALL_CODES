void push_stack(int* stack, int* top, int value) {
    stack[++*top] = value;
}

int pop_stack(int* stack, int* top) {
    return stack[(*top)--];
}