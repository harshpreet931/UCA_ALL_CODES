#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>
#include <limits.h>
#include <sys/time.h>

struct Node {
    int item;
    struct Node* next;
};

typedef struct Node Node;
Node* head = NULL;
int N = 0;

void push(int item) {
    Node* oldhead = head;
    head = (Node *) malloc(sizeof(Node));
    head->item = item;
    head->next = oldhead;
    N++;
}

int pop() {
    if (N == 0) return INT_MIN;
    int item = head->item;
    Node* temp = head;
    head = head->next;
    N--;
    free(temp);
    return item;
}

int size() {
    return N;
}

bool isEmpty() {
    return N == 0;
}

long long current_time_millis() {
    struct timeval time;
    gettimeofday(&time, NULL);
    return time.tv_sec * 1000LL + time.tv_usec / 1000;
}

void analyze_stack_operations(int num_operations) {
    long long start_time, end_time;

    start_time = current_time_millis();
    for (int i = 0; i < num_operations; i++) {
        push(i);
    }
    end_time = current_time_millis();
    printf("Time for %d push operations: %lld ms\n", num_operations, end_time - start_time);

    start_time = current_time_millis();
    for (int i = 0; i < num_operations; i++) {
        pop();
    }
    end_time = current_time_millis();
    printf("Time for %d pop operations: %lld ms\n", num_operations, end_time - start_time);
}

void testStack() {
    push(3);
    push(10);
    push(20);

    assert(isEmpty() == false);
    assert(size() == 3);
    assert(pop() == 20);
    assert(size() == 2);
    assert(pop() == 10);
    assert(size() == 1);
    assert(pop() == 3);
    assert(size() == 0);
    assert(isEmpty());
}

int main() {
    testStack();
    printf("All tests passed.\n");

    analyze_stack_operations(100);
    analyze_stack_operations(1000);
    analyze_stack_operations(10000);
    analyze_stack_operations(100000);
    analyze_stack_operations(1000000);
    analyze_stack_operations(10000000);
    analyze_stack_operations(100000000);

    return 0;
}
