#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};
typedef struct Node node;

node *head;

node *create()
{
    int k, n;
    node *p, *head;

    printf("\n Enter the number of nodes: ");
    scanf("%d", &n);

    printf("Enter the data for each node in ascending order of their value: ");
    for (k = 0; k < n; k++)
    {
        if (k == 0)
        {
            head = (node *)malloc(sizeof(node));
            p = head;
        }
        else
        {
            p->next = (node *)malloc(sizeof(node));
            p = p->next;
        }
        scanf("%d",&p->data);
    }
    p->next = NULL;
    return (head);
}

void display(node *head)
{
    node *p = head;
    while (p != NULL)
    {
        printf("%d ", p->data);
        p = p->next;
    }
}

struct Node *newNode(int data)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void insertion_sort(struct Node **head, node *newNode)
{
    if (*head == NULL || (*head)->data >= newNode->data)
    {
        newNode->next = *head;
        *head = newNode;
        return;
    }

    struct Node *current = *head;
    while (current->next != NULL && current->next->data < newNode->data)
        current = current->next;

    newNode->next = current->next;
    current->next = newNode;
}

int main()
{
    int k;
    
    head = create();

    printf("Linked list before insertion : ");
    display(head);

    printf("\nEnter data you want to insert: ");
    scanf("%d", &k);

    insertion_sort(&head, newNode(k));

    printf("Linked list after insertion : ");
    display(head);

    return 0;
}