#include <iostream>
using namespace std;

int bSearch(vector<int> nums, int k) {
    int n=nums.size();
    int low=0, high=n-1;
    while (low<=high) {
        int mid = (low+high)/2;
        if (nums[mid]==k) {
            return mid;
        }
        else if (nums[mid]>k) {
            high=mid-1;
        }
        else {
            low=mid+1;
        }
    }
    return -1;
}

int main() {

    int n, key;
    cout<<"Enter the size of array: ";
    cin>>n;
    cout<<endl;
    vector<int> arr(n);
    cout<<"Enter the elements of array: ";
    for (int i=0; i<n; i++) {
        cin>>arr[i];
    }
    cout<<endl;
    cout << "Enter element to search: ";

    cin >> key;

    int result = bSearch(arr, key);
    if(result==-1) {
        cout<<"Number not found";
    }
    else {
        cout<<"Number is found at index: "<<result;
    }

    return 0;

}