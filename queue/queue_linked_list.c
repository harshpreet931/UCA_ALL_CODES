#include <stdio.h>
#include <stdbool.h>
#include <assert.h>
#include <stdlib.h>
#include <limits.h>

struct Node {
    int item;
    struct Node* next;
};

typedef struct Node Node;
Node* head = NULL;
Node* tail = NULL;
int N = 0;

bool isEmpty() {
    return N == 0;
}

void push(int item) {
    Node* oldtail = tail;
    tail = (Node*) malloc(sizeof(Node));
    tail->item = item;
    tail->next = NULL;

    if(isEmpty()) head = tail;
    else oldtail->next = tail;
    N++;
}

int pop() {
    if(isEmpty()) return INT_MIN;
    int item = head->item;
    Node* temp = head;
    head = head->next;
    if(isEmpty()) tail = NULL;
    N--;
    free(temp);
    return item;
}

int size() {
    return N;
}

void testQueue() {
    push(3);
    push(10);
    push(20);

    assert(isEmpty() == false);
    assert(size() == 3);
    assert(pop() == 3);
    assert(size() == 2);
    assert(pop() == 10);
    assert(size() == 1);
    assert(pop() == 20);
    assert(size() == 0);
    assert(isEmpty());
}

int main() {
    testQueue();
    printf("All tests passed!!\n");
    return 0;
}
