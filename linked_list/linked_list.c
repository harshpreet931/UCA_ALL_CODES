#include <stdio.h>

typedef struct LinkedListNode {
    Node* node;
    int data;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node *) malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void insertAtStart(

int main() {
    


    return 0;
}
