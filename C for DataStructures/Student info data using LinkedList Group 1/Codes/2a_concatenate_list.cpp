#include<bits/stdc++.h>
#include "CustomLinkedList.h"

template <typename T>

Node<T>* concList(Node<T>* head1, Node<T>* head2) {
    CustomLinkedList<T> l3;
    Node<T>* temp = head1;
    while (temp != nullptr) {
        T data = temp->data;
        l3.insertAtTail(data);
        temp = temp->next;
    }
    temp = head2;
    while (temp != nullptr) {
        T data = temp->data;
        l3.insertAtTail(data);
        temp = temp->next;
    }
    return l3.head;
}

int main() {
    // Dynamically declared Linked List
    CustomLinkedList<int> *l1 = new CustomLinkedList<int>();
    int num1; 
    cout << "Enter the number of elements in list1: "; cin >> num1;
    int cnt = 1;
    while(num1--) {
        if(cnt == 1) cout << "Enter " << cnt++ << "st element: "; 
        else if(cnt == 2) cout << "Enter " << cnt++ << "nd element: "; 
        else if(cnt == 3) cout << "Enter " << cnt++ << "rd element: "; 
        else cout << "Enter " << cnt++ << "th element: "; 
        int data; cin >> data;
        l1->insertAtTail(data);
    }
    l1->printList();

    // Statically declared Linked List
    CustomLinkedList<int> l2;
    int num2; 
    cout << "Enter the number of elements in list2: "; cin >> num2;
    cnt = 1;
    while(num2--) {
        if(cnt == 1) cout << "Enter " << cnt++ << "st element: "; 
        else if(cnt == 2) cout << "Enter " << cnt++ << "nd element: "; 
        else if(cnt == 3) cout << "Enter " << cnt++ << "rd element: "; 
        else cout << "Enter " << cnt++ << "th element: "; 
        int data; cin >> data;
        l2.insertAtTail(data);
    }
    l2.printList();

    // Concatenating both the Lists into a new List
    cout << "The concatenated list is:-" << endl;
    CustomLinkedList<int> l3;
    l3.head = concList(l1->head, l2.head);
    // Printing the Concatenated List
    l3.printList();

    return 0;
}
