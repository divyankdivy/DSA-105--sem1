#include <iostream>
using namespace std;


void storeDiagonal(vector<int>& arr) {
    int n=arr.size();
    cout<<"Enter the diagonal Elements: ";

    for (int i=0; i<n; i++) {
        cin>>arr[i];
    }
}

void displayMatrix(vector<int>& arr) {
    int n = arr.size();

    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (j==i) {
                cout<<arr[i]<<" ";
            }
            else {
                cout<<"0 ";
            }
        }
        cout<<endl;
    }
}

int main() {
    int n;
    cout<<"Enter the size of matrix: ";
    cin>>n;

    vector<int> nums(n);
    storeDiagonal(nums);

    displayMatrix(nums);

    return 0;
}