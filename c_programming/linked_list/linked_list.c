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
int N = 0;

bool isEmpty() {
    return N == 0;
}

int size() {
    return N;
}

void push(int item) {
    Node* newNode = (Node *) malloc(sizeof(Node));
    newNode->item = item;
    newNode->next = head;
    head = newNode;
    N++;
}

int get(int idx) {
    if(idx < 0 || idx >= N) return INT_MIN;

    Node* curr = head;
    for(int i = 0; i < idx; i++) curr = curr->next;

    return curr->item;
}

int removeAt(int idx) {
    if(idx < 0 || idx >= N) return INT_MIN;

    Node* curr = head;
    Node* prev = NULL;
    for(int i = 0; i < idx; i++) {
        prev = curr; 
        curr = curr->next;
    }
    
    int item = curr->item;
   
    if(prev == NULL) head = curr->next;
    else prev->next = curr->next;
   
    free(curr);
    N--;
    return item; 
}
    
void testLinkedList() {
    push(3);
    push(10);
    push(20);

    assert(isEmpty() == false);
    assert(size() == 3);
    assert(get(0) == 20);
    assert(get(1) == 10);
    assert(get(2) == 3);
    assert(removeAt(1) == 10);
    assert(size() == 2);
    assert(get(0) == 20);
    assert(get(1) == 3);
    assert(removeAt(0) == 20);
    assert(size() == 1);
    assert(get(0) == 3);
    assert(removeAt(0) == 3);
    assert(size() == 0);
    assert(isEmpty());
}

int main() {
    testLinkedList();
    printf("All tests passed!!\n");
    return 0;
}
