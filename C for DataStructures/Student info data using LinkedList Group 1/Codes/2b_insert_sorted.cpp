#include <iostream>
#include "CustomLinkedList.h"

template <typename T>

void insert_sorted(Node<T>** head,  Node<T>* element) {
    Node<T>* curr = *head;
    Node<T>* prev = nullptr;

    // Find the correct position to insert the element
    while (curr != nullptr && curr->data < element->data) {
        prev = curr;
        curr = curr->next;
    }

    // Update the links to insert the element
    if (prev == nullptr) {
        // Insert at the beginning of the list
        element->next = *head;
        *head = element;
    } else {
        // Insert in the middle or at the end of the list
        prev->next = element;
        element->next = curr;
    }
}

int main() {
    CustomLinkedList<int> l1;

    // Insert elements in sorted order
    cout << "Enter the number of elements to insert in list: ";
    int n; cin >> n;
    int cnt = 1;
    while(n--) {
        if(cnt == 1) cout << "Enter " << cnt++ << "st element: "; 
        else if(cnt == 2) cout << "Enter " << cnt++ << "nd element: "; 
        else if(cnt == 3) cout << "Enter " << cnt++ << "rd element: "; 
        else cout << "Enter " << cnt++ << "th element: "; 
        int data; cin >> data;
        insert_sorted(&l1.head, new Node<int>(data));
    }
    // Print the final linked list
    l1.printList();

    return 0;
}
