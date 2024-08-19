#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    void **elements;
    size_t size; 
    size_t capacity;
} List;

void initList(List *list, size_t initialCapacity) {
    list->elements = (void **)malloc(initialCapacity * sizeof(void *));
    list->size = 0;
    list->capacity = initialCapacity;
}

void addElement(List *list, void *element) {
    if (list->size == list->capacity) {
        list->capacity *= 2;
        list->elements = (void **)realloc(list->elements, list->capacity * sizeof(void *));
    }
    list->elements[list->size++] = element;
}

void printList(List *list, void (*printFunc)(void *)) {
    for (size_t i = 0; i < list->size; i++) {
        printFunc(list->elements[i]);
    }
    printf("\n");
}

void sortList(List *list, int (*compareFunc)(const void *, const void *)) {
    for (size_t i = 0; i < list->size - 1; i++) {
        for (size_t j = 0; j < list->size - i - 1; j++) {
            if (compareFunc(list->elements[j], list->elements[j + 1]) > 0) {
                void *temp = list->elements[j];
                list->elements[j] = list->elements[j + 1];
                list->elements[j + 1] = temp;
            }
        }
    }
}

int compareInt(const void *a, const void *b) {
    int intA = *(int *)a;
    int intB = *(int *)b;
    return (intA > intB) - (intA < intB);
}

int compareString(const void *a, const void *b) {
    char *strA = *(char **)a;
    char *strB = *(char **)b;
    return strcmp(strA, strB);
}

void printInt(void *element) {
    printf("%d ", *(int *)element);
}

void printString(void *element) {
    printf("%s ", *(char **)element);
}

int main() {
    List intList;
    List stringList;

    initList(&intList, 5);
    initList(&stringList, 5);

    int a = 5, b = 2, c = 9, d = 1;
    addElement(&intList, &a);
    addElement(&intList, &b);
    addElement(&intList, &c);
    addElement(&intList, &d);

    char *str1 = "banana";
    char *str2 = "guvava";
    char *str3 = "mango";
    char *str4 = "apple";
    addElement(&stringList, &str1);
    addElement(&stringList, &str2);
    addElement(&stringList, &str3);
    addElement(&stringList, &str4);

    printf("Integer List before sorting: ");
    printList(&intList, printInt);
    sortList(&intList, compareInt);
    printf("Integer List after sorting: ");
    printList(&intList, printInt);

    printf("String List before sorting: ");
    printList(&stringList, printString);
    sortList(&stringList, compareString);
    printf("String List after sorting: ");
    printList(&stringList, printString);

    free(intList.elements);
    free(stringList.elements);

    return 0;
}
