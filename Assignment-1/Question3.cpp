#include <iostream>
using namespace std;

void leftRotateBrute(int nums[], int n, int k) {
    int temp[k];
    for (int i=0; i<k; i++) {
        temp[i] = nums[i];
    }
    int leftCounter=0;
    for (int i=k; i<n; i++) {
        nums[leftCounter] = nums[i];
        leftCounter++;
    }
    int backtempCounter = 0;
    for (; leftCounter<n; leftCounter++) {
        nums[leftCounter] = temp[backtempCounter];
        backtempCounter++;
    }
}

void rightRotateBrute(int nums[], int n, int k) {
    int temp[k];
    int tempCounter = 0;
    for (int i=n-1; i>=n-k; i--) {
        temp[tempCounter] = nums[i];
        tempCounter++;
    }

    for (int i=n-1; i>=k; i--) {
        nums[i] = nums[i-k];
    }
    for (int i=0; i<k; i++) {
        tempCounter--;
        nums[i] = temp[tempCounter];
        
    }
}

int main() {

    int nums[] = {1,2, 3, 4, 5};
    int n=sizeof(nums)/sizeof(nums[0]);
    leftRotateBrute( nums, n, 2);
    for (int i=0; i<n; i++) {
        cout<<nums[i]<<" ";
    }
    cout<<endl;
    rightRotateBrute(nums, n, 2);
    for (int i=0; i<n; i++) {
        cout<<nums[i]<<" ";
    }

    return 0;
}