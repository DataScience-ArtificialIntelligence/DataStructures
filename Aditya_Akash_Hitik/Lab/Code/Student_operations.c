#include<stdlib.h>
#include<string.h>
#include<stdio.h>
struct Student
{
    int rollnumber;
    char name[100];
    char phone[100];
    float CGPA;
    struct Student *next;
    
};
struct Student * insert(struct Student *head, int rollnumber, char name[100], char phone[100], float percentage)
{
    
    struct Student * student = (struct Student *) malloc(sizeof(struct Student));
    student->rollnumber = rollnumber;
    strcpy(student->name, name);
    strcpy(student->phone, phone);
    student->CGPA = percentage;
    student->next = NULL;
    
    if(head==NULL)
    {
        /* if head is NULL, set student as the new head */
        head = student;
    }
    else{
        /* if list is not empty
         insert student in beginning of head */
        student->next = head;
        head = student;
    }
    
    return head;
    
}
void search(struct Student *head, int rollnumber)
{
    struct Student * temp = head;
    while(temp!=NULL){
        if(temp->rollnumber==rollnumber){
            printf("Roll Number: %d\n", temp->rollnumber);
            printf("Name: %s\n", temp->name);
            printf("Phone: %s\n", temp->phone);
            printf("Percentage: %0.4f\n", temp->CGPA);
            return;
        }
        temp = temp->next;
    }
    printf("Student with roll number %d is not found !!!\n", rollnumber);
}

struct Student * Delete(struct Student *head, int rollnumber)
{
    struct Student * temp1 = head;
    struct Student * temp2 = head; 
    while(temp1!=NULL){
        
        if(temp1->rollnumber==rollnumber){
            
            
            if(temp1==temp2){
                /* this condition will run if
                the record that we need to delete is the first node
                of the linked list */
                head = head->next;
                free(temp1);
            }
            else{
                /* temp1 is the node we need to delete
                 temp2 is the node previous to temp1 */
                temp2->next = temp1->next;
                free(temp1); 
            }
            
            return head;
            
        }
        temp2 = temp1;
        temp1 = temp1->next;
        
    }
    
    return head;
    
}
void display(struct Student *head)
{
    struct Student * temp = head;
    while(temp!=NULL){
        
        printf("Roll Number: %d\n", temp->rollnumber);
        printf("Name: %s\n", temp->name);
        printf("Phone: %s\n", temp->phone);
        printf("Percentage: %0.4f\n\n", temp->CGPA);
        temp = temp->next;
        
    }
}
struct Student * sort(struct Student *head){
    
    struct Student *temp = NULL;
    struct Student *ptr;
    struct Student *lptr;
    while(head!=NULL){
        
        ptr = head;
        lptr = head;
        while(ptr!=NULL){
            if(ptr->rollnumber > lptr->rollnumber){
                lptr = ptr;
            }
            ptr = ptr->next;
        }
        temp = insert(temp, lptr->rollnumber, lptr->name, lptr->phone, lptr->CGPA);
        head = Delete(head, lptr->rollnumber);
    }
    return temp;
    
}
int main()
{
    struct Student *head = NULL;
    int choice;
    char name[100];
    char phone[100];
    int rollnumber;
    float CGPA;
    printf("1 to insert student details\n2 to search for student details\n3 to delete student details\n4 to to display all student details \n5 to sort records based on roll number \n6 to exit");
    do
    {
        printf("\nEnter Choice: ");
        scanf("%d", &choice);
        switch (choice)
        {
            case 1:
                printf("Enter roll number: ");
                scanf("%d", &rollnumber);
                printf("Enter name: ");
                scanf("%s", name);
                printf("Enter phone number: ");
                scanf("%s", phone);
                printf("Enter CGPA: ");
                scanf("%f", &CGPA);
                head = insert(head,rollnumber, name, phone, CGPA);
                break;
            case 2:
                printf("Enter roll number to search: ");
                scanf("%d", &rollnumber);
                search(head,rollnumber);
                break;
            case 3:
                printf("Enter roll number to delete: ");
                scanf("%d", &rollnumber);
                head = Delete(head, rollnumber);
                break;
            case 4:
               display(head);
                break;
            case 5:
                head = sort(head);
                break;
            case 6: break;    
           
        }
        
    } while (choice != 6);
}