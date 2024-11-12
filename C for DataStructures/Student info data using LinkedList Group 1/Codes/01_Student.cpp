#include <iostream>
using namespace std;

struct stud
{
    int roll;
    string name;
    int age;
    struct stud *next;
};

typedef struct stud node;
node *head;

// creating a list of students
node *create_list()
{
    int k, n;
    node *p, *head;
    cout << ("\nHow many Students to enter? ");
    cin >> n;
    cin.ignore();   // Ignore the newline character in the input buffer
    head = nullptr; // Initialize the head to nullptr

    for (k = 0; k < n; k++)
    {
        node *newstud = new node;
        cout << "\nEnter details: Roll Number, Name, and Age respectively\n";
        cin >> newstud->roll;
        cin.ignore(); // Ignore the newline character in the input buffer
        getline(cin, newstud->name);
        cin >> newstud->age;
        cin.ignore(); // Ignore the newline character in the input buffer
        newstud->next = nullptr;

        if (head == nullptr || newstud->roll < head->roll) // Insert at the beginning
        {
            newstud->next = head;
            head = newstud;
        }
        else
        {
            p = head;
            while (p->next != nullptr && p->next->roll < newstud->roll)
            {
                p = p->next;
            }
            newstud->next = p->next;
            p->next = newstud;
        }
    }
    return head;
}

// displaying the list of students
void display(node *head)
{
    int count = 1;
    node *p;
    p = head;
    while (p != NULL)
    {
        cout << endl
             << "Student(Roll no., name, age): " << p->roll << " " << p->name << " " << p->age << endl;
        count++;
        p = p->next;
    }
    cout << endl;
}

// inserting a student
void insert(node **head)
{
    int rno;
    node *p, *q, *newstud;
    newstud = new node;
    cout << "\nEnter details: Roll Number, Name, and Age respectively\n";
        cin >> newstud->roll;
        cin.ignore(); // Ignore the newline character in the input buffer
        getline(cin, newstud->name);
        cin >> newstud->age;
        cin.ignore();
        newstud->next = nullptr;

    if (*head == nullptr || newstud->roll < (*head)->roll) // Insert at the beginning
    {
        newstud->next = *head;
        *head = newstud;
    }
    else
    {
        p = *head;
        while (p->next != nullptr && p->next->roll < newstud->roll)
        {
            p = p->next;
        }
        newstud->next = p->next;
        p->next = newstud;
    }
}

// deleting a student
void deletestud(node **head)
{
    if (*head == nullptr)
    {
        cout << "\nThe list is empty. Please add something before deleting.\n";
        return;
    }
    int rno;
    node *p, *q;
    cout << endl
         << "Delete for roll :";
    cin >> rno;
    p = *head;
    if (p->roll == rno) /* Delete the first element */
    {
        *head = p->next;
        free(p);
    }
    else
    {
        while ((p != NULL) && (p->roll != rno))
        {
            q = p;
            p = p->next;
        }
        if (p == NULL) /* Element not found */
            cout << endl
                 << "No match deletion failed\n";
        else if (p->roll == rno)
        /* Delete any other element */
        {
            q->next = p->next;
            free(p);
        }
    }
}

// main function
int main()
{
    head == nullptr;
    bool p = true;
    while (p)
    {
        cout << ("Select choice:\n");
        cout << ("1.Create a list of students: \n");
        cout << ("2.Inserting a student in the list\n");
        cout << ("3.Deleting a student from the list\n");
        cout << ("4.Displaying the list of students:\n");
        cout << ("5.Exit");
        cout << endl;
        int ch;
        cin >> ch;
        switch (ch)
        {
        case 1:
            head = create_list();
            break;
        case 2:
            insert(&head);
            break;
        case 3:
            deletestud(&head);
            break;
        case 4:
            display(head);
            break;
        case 5:
            cout << "Exiting...";
            exit(1);
            break;
        default:
            cout << "Invalid choice.. try again";
        }
    }
    return 0;
}
