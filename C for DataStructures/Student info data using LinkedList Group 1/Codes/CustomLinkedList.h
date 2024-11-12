#ifndef CUSTOM_LINKEDLIST_H
#define CUSTOM_LINKEDLIST_H

#include <iostream>
using namespace std;
template <typename T>

class Node {
public:
    T data;
    Node<T>* next;

    Node(const T& value) {
        data = value;
        next = nullptr;
    }
};

template <typename T>
class CustomLinkedList {
public:
    Node<T>* head;

public:
    CustomLinkedList() {
        head = nullptr;
    }

    bool isEmpty() const {
        return head == nullptr;
    }

    void insertAtHead(const T& value) {
        Node<T>* newNode = new Node<T>(value);
        newNode->next = head;
        head = newNode;
    }

    void insertAtTail(const T& value) {
        Node<T>* newNode = new Node<T>(value);

        if (head == nullptr) {
            head = newNode;
        } else {
            Node<T>* temp = head;
            while (temp->next != nullptr) {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }

    void insertAtPosition(const T& value, int position) {
        if (position <= 0) {
            insertAtHead(value);
        } else {
            Node<T>* newNode = new Node<T>(value);
            Node<T>* temp = head;
            int count = 0;

            while (count < position - 1 && temp->next != nullptr) {
                temp = temp->next;
                count++;
            }

            newNode->next = temp->next;
            temp->next = newNode;
        }
    }

    void deleteAtTail() {
        if (head == nullptr) {
            return;
        }

        if (head->next == nullptr) {
            delete head;
            head = nullptr;
            return;
        }

        Node<T>* prev = nullptr;
        Node<T>* curr = head;

        while (curr->next != nullptr) {
            prev = curr;
            curr = curr->next;
        }

        prev->next = nullptr;
        delete curr;
    }

    void printList() const {
        Node<T>* temp = head;
        while (temp != nullptr) {
            std::cout << temp->data << " -> ";
            temp = temp->next;
        }
        std::cout << "NULL\n";
    }

    Node<T> begin() const {
        return head;
    }
};

#endif // CUSTOM_LINKEDLIST_H
