#include <iostream>
#include "CustomQueue.h"

using namespace std;

int main() {
    CustomQueue<int> *cq = new CustomQueue<int>();
    while (true) {
        cout << "Enter the operation to perform\n";
        cout << "1. Enqueue\n";
        cout << "2. Dequeue\n";
        cout << "3. Peek front\n";
        cout << "4. Print elements in queue\n";
        cout << "5. Exit\n";
        int n;
        cin >> n;

        switch (n) {
            case 1: {
                cout << "Enter element to insert\n";
                int data;
                cin >> data;
                cq->enqueue(data);
                break;
            }
            case 2: {
                if (!cq->isEmpty())
                    cout << "Dequeued element at the front is " << cq->dequeue() << endl;
                else
                    cout << "Queue is empty. Unable to dequeue." << endl;
                break;
            }
            case 3: {
                if (!cq->isEmpty())
                    cout << "Element at the front is " << cq->peek() << endl;
                else
                    cout << "Queue is empty. No element to peek." << endl;
                break;
            }
            case 4: {
                cout << "Elements in the queue are ->" << endl;
                cq->printQueue();
                break;
            }
            case 5: {
                cout << "Exiting program..." << endl;
                return 0;
            }
            default:
                cout << "Invalid input entered. Please enter again." << endl;
        }
    }
    delete cq;

    return 0;
}
