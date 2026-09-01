#include <iostream>
using namespace std;

void storMatrix(vector<int>& arr) {
    int n=arr.size();

    cout<<"Enter elements for matrix: ";

    for (int i=0; i<n*3-2; i++) {
        cin>>arr[i];
    }
}

void displayMatrix(vector<int>& arr) {
    int n=arr.size();
    int k=0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (j==i || j==i+1 || i==j+1) {
                cout<<arr[k]<<" ";
                k++;
            }else {
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

    storMatrix(nums);
    cout<<endl;
    displayMatrix(nums);
    return 0;
}