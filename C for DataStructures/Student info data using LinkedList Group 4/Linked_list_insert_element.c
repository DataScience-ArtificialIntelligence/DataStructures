#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
} *temp = NULL, *head = NULL;

struct Node *Create(int A[], int n)
{
    int i;
    struct Node *t, *last;
    temp = (struct Node *)malloc(sizeof(struct Node));
    temp->data = A[0];
    temp->next = NULL;
    last = temp;

    for (i = 1; i < n; i++)
    {
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = A[i];
        t->next = NULL;
        last->next = t;
        last = t;
    }
    return temp;
}

void Display(struct Node *p)
{
    while (p != NULL)
    {
        printf("%d ", p->data);
        p = p->next;
    }
}

void insert_sorted(struct Node **head, struct Node *element)
{
    struct Node *current = *head;
    struct Node *previous = NULL;

    // Traverse the list to find the appropriate position to insert the element
    while (current != NULL && current->data < element->data)
    {
        previous = current;
        current = current->next;
    }

    // Insert the element at the beginning of the list
    if (previous == NULL)
    {
        element->next = *head;
        *head = element;
    }
    // Insert the element in the middle or at the end of the list
    else
    {
        previous->next = element;
        element->next = current;
    }
}


int main()
{
    int n, m;
    printf("Enter the size of linked list: ");
    scanf("%d", &n);
    
    printf("Enter the elements of the list: ");
    int A[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &A[i]);
    }

    printf("Enter the element to be entered: ");
    scanf("%d", &m);

    head = Create(A, n);

    printf("Linked List: \n");
    Display(head);

    insert_sorted(&head, &m);

    printf("\n\nConcantenated Linked List: \n");
    Display(head);
    return 0;
}