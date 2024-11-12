#include <stdio.h>
#include <stdlib.h>


struct student {
    int rollno;
    char name[50];
    int age;
    struct student *next;
};
typedef struct student node;
    node *head;


node *create_list()
{
int k, n;
node *p, *head;
printf("\n How many elements to enter: \n");
scanf("%d", &n);
int tempcount=1;
for (k=0; k<n; k++)
{ if (k == 0) {
head = (node *) malloc(sizeof(node));
p = head;
}
else {
p->next = (node *) malloc(sizeof(node));
p = p->next;
}
printf("Enter the rollno, name and age of the student %d: ",tempcount);
scanf ("%d %s %d", &p->rollno, p->name, &p->age);
tempcount++;
}
p->next = NULL;
return (head);
}
void display (node *head)
{
int count = 1;
node *p;
p = head;
printf("           Rollno \tName \tAge");
while (p!= NULL)
{
printf("\nStudent %d: %d \t\t%s \t%d", count, p->rollno, p->name, p->age);
count++;
p = p->next;
}
printf ("\n");
}

void insert (node **head)
{
int k = 0, rno;
node *p, *q, *new;
new = (node *) malloc(sizeof(node));
printf ("\nData to be inserted: ");
scanf ("%d %s %d", &new->rollno, new->name, &new->age);
printf ("\nInsert the added data before rollno (-ve for end):");
scanf ("%d", &rno);
p = *head;
if (p->rollno == rno)
{ new->next = p;
*head = new;
}
else
{
while ((p != NULL) && (p->rollno != rno))
{ q = p;
p = p->next;
}
if (p == NULL)
{ q->next = new;
new->next = NULL;
}
else if (p->rollno == rno)

{ q->next = new;
new->next = p;
}
}
}
void delete (node **head)
{ int rno;
node *p, *q;
printf ("\nDelete the data or replace the rollno :");
scanf ("%d", &rno);
p = *head;
if (p->rollno == rno)
{ *head = p->next;
free (p);
}
else
{ while ((p != NULL) && (p->rollno != rno))
{ q = p;
p = p->next;
}
if (p == NULL)
printf ("\nNo match deletion failed");
else if (p->rollno == rno)

{ q->next = p->next;
free (p);
}
}
}

int main() {
head=create_list();
display(head);
insert(&head);
delete(&head);
display(head);
}