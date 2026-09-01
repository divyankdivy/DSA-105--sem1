#include <iostream>

#include <vector>

using namespace std;

void storeElements(vector<int>& arr, int n) {
    cout << "Enter the elements: ";
    for (int i=0; i<n*(n+1)/2; i++) {
        cin >> arr[i];
    }
}

void displayMatrix(vector<int>& arr, int n) {
    cout << "Symmetric Matrix:" << endl;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (i>=j) {
                int index = i*(i+1)/2 + j;
                cout << arr[index] << " ";
            }

            else {
                int index = j*(j+1)/2 + i;
                cout << arr[index] << " ";
            }
        }
        cout << endl;
    }
}

int main() {
    int n;
    cout << "Enter the size of matrix: ";
    cin >> n;
    vector<int> arr(n*(n+1)/2);
    storeElements(arr, n);
    displayMatrix(arr, n);
    return 0;
}