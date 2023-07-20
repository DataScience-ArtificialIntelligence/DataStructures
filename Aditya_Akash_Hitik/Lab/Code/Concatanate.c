#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
} *temp = NULL, *first = NULL, *second = NULL;
struct Node* Create(int A[], int n)
{
    int i;
    struct Node *t, *last;
    temp = (struct Node *) malloc(sizeof(struct Node));
    temp->data = A[0];
    temp->next = NULL;
    last = temp;
    for (i = 1; i < n; i++)
    {
        t = (struct Node *) malloc(sizeof(struct Node));
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
        printf ("%d ", p->data);
        p = p->next;
    }
}
void Concatanate(struct Node *node1, struct Node *node2)
{
    struct Node *p = first;
    while (p->next != NULL)
    {
        p = p->next;
    }
    p->next = second;
    second = NULL;
}
int main()
{
    int n;
    scanf("%d",&n);
    int A[n],B[n];
    for (int i=0;i<n;i++) {
        scanf("%d",&A[i]);
    }
    for (int i=0;i<n;i++) {
        scanf("%d",&B[i]);
    }
    first = Create(A, 4);
    second = Create(B, 4);
    printf ("1st Linked List: ");
    Display (first);
    printf ("\n2nd Linked List: ");
    Display (second);
    Concatanate (first, second);
    printf ("\n\nConcantenated Linked List: \n");
    Display (first);
    return 0;
}