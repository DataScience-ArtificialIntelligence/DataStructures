#ifndef CUSTOM_QUEUE_H
#define CUSTOM_QUEUE_H

#include "CustomLinkedList.h"
using namespace std;
template <typename T>

class CustomQueue {
private:
    CustomLinkedList<T> list;
public:
    CustomQueue() {}

    void enqueue(const T& data) {
        list.insertAtTail(data);
    }

    T peek() const {
        if (!list.isEmpty()) {
            return list.head->data;
        } else {
            cout << "Nullptr Exception. Returning default value." << endl;
            return T();
        }
    }

    T dequeue() {
        if (!list.isEmpty()) {
            T data = list.head->data;
            list.head = list.head->next;
            return data;
        } else {
            cout << "Nullptr Exception. Returning default value." << endl;
            return T();
        }
    }

    void printQueue() const {
        if (list.isEmpty()) {
            cout << "No elements to print." << endl;
            return;
        }
        list.printList();
    }

    bool isEmpty() {
        return list.head == nullptr;
    }
};

#endif // CUSTOM_QUEUE_H
