#include <iostream>
#include <queue>
using namespace std;


bool isEmpty(int front) {
    return front == -1;
}

bool isFull(int rear, int size) {
    return rear == size-1;
}

void enqueue(int queueArr[], int &front, int &rear, int size) {

    int value;

    if (isFull(rear, size)) {
        return;
    }

    cout << "Enter value: ";
    cin >> value;

    if (front == -1)
        front = 0;
    rear++;

    queueArr[rear] = value;
}

int main() {
    int size;
    cin>>size;

    int aArr[size];
    int front = -1;
    int rear = -1;
}