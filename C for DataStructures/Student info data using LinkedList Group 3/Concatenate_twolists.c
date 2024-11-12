#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
} *temp = NULL, *head1 = NULL, *head2 = NULL;

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


void Concat(struct Node *head1, struct Node *head2)
{
    struct Node *p = head1;
    while (p->next != NULL)
    {
        p = p->next;
    }
    p->next = head2;
    head2 = NULL;
}

int main()
{
    int n,m;
    printf("Enter the size of first linked list\n");
    scanf("%d",&n);
    printf("Enter the size of second linked list\n");
    scanf("%d",&m);
    int A[n],B[m];
    printf("Enter the elements of the first linked list\n");
    for(int i=0;i<n;i++) {
        scanf("%d",&A[i]);
    }
    printf("Enter the elemnts of the second linked list\n");
    for(int i=0;i<m;i++) {
        scanf("%d",&B[i]);
    }
    

    
head1 = Create(A, n);
    head2= Create(B, m);

    printf ("1st Linked List: ");
    Display (head1);

    printf ("\n2nd Linked List: ");
    Display (head2);

    Concat (head1, head2);

    printf ("\n\nConcantenated Linked List: \n");
    Display (head1);
    return 0;
}