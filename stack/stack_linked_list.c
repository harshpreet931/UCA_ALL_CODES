#include <stdio.h>
#include <stdbool.h>
#include <assert.h>
#include <stdlib.h>
#include "stack.h"
#include <limits.h>

struct Node {
    int item;
    struct Node* next;
};

typedef struct Node Node;
Node* head = NULL;
int N = 0;

void push(int item) { // N operations -> O(N)
    Node* oldhead = head;

    head = (Node *) malloc(sizeof(Node)); // good programming to cast it to an appropriate datatype since some compilers might not like it.
    head->item = item;
    head->next = oldhead;
    N++;
}

int pop() { // N operations -> O(N)
    if(N == 0) return INT_MIN;
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

int testStack() {
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
    return 0;
}