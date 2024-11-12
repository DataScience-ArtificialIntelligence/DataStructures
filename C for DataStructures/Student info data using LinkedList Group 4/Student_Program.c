#include <stdio.h>
#include <stdlib.h>

struct Student
{
    int roll_no;
    char name[50];
    int age;
    struct student *next;
};
typedef struct Student node;

node *head;

node *create_list()
{
    int k, n;
    node *p, *head;

    printf("\n Enter the number of students: ");
    scanf("%d", &n);

    printf("Enter the roll number, name and age of each student: ");
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
        scanf("%d %s %d", &p->roll_no, p->name, &p->age);
    }
    p->next = NULL;
    return (head);
}

void display(node *head)
{
    int count = 1;
    node *p;
    p = head;
    while (p != NULL)
    {
        printf("\nStudent %d: %d %s %d", count, p->roll_no, p->name, p->age);
        count++;
        p = p->next;
    }
    printf("\n");
}

void insert(node **head)
{
    int k = 0, r_no;
    node *p, *q, *new;
    new = (node *)malloc(sizeof(node));

    printf("\nData to be inserted: ");
    scanf("%d %s %d", &new->roll_no, new->name, &new->age);

    printf("\nInsert before roll (-ve for end):");
    scanf("%d", &r_no);

    p = *head;
    if (p->roll_no == r_no)
    {
        new->next = p;
        *head = new;
    }

    else
    {
        while ((p != NULL) && (p->roll_no != r_no))
        {
            q = p;
            p = p->next;
        }
        if (p == NULL)
        {
            q->next = new;
            new->next = NULL;
        }
        else if (p->roll_no == r_no)
        {
            q->next = new;
            new->next = p;
        }
        
    }
}
void delete(node **head)
{
    int r_no;
    node *p, *q;

    printf("\nDelete for roll :");
    scanf("%d", &r_no);

    p = *head;
    if (p->roll_no == r_no)
    {
        *head = p->next;
        free(p);
    }

    else
    {
        while ((p != NULL) && (p->roll_no != r_no))
        {
            q = p;
            p = p->next;
        }
        if (p == NULL)
            printf("\nNo match found");
        else if (p->roll_no == r_no)
        {
            q->next = p->next;
            free(p);
        }
    }
}

int main()
{
    head = create_list();
    display(head);
    insert(&head);
    delete (&head);
    display(head);
}