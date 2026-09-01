#include <iostream>
using namespace std;

void storeMatrix(vector<int>& nums) {
    int n=nums.size();

    cout<<"Enter elements for the matrix: ";

    for (int i=0; i<n*(n+1)/2; i++) {
        cin>>nums[i];
    }
}

void displayMatrix(vector<int>& nums) {
    int k=0;
    int n=nums.size();

    for (int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if (i>=j) {
                cout<<nums[k]<<" ";
                k++;
            }
            else {
                cout<<0<<" ";
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

    storeMatrix(nums);
    cout<<endl;
    displayMatrix(nums);
    return 0;
}