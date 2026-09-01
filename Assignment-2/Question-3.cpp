#include <iostream>
#include <vector>
using namespace std;

int findMissingLinear(vector<int> arr) {
    int n=arr.size()+1;
    int start = arr[0], end = arr[n];
    int expectedSum = ((start+(start+n-1))*n)/2;
    int actualSum=0;
    for (int i=0; i<n; i++) {
        actualSum+=arr[i];
    }
    int missing = expectedSum-actualSum;
    return missing;
}

int findMissingBinary(vector<int> nums) {
    int low=0, high=nums.size()-1;
    int start=nums[0];

    while (low<=high) {
        int mid = (low+high)/2;

        if (nums[mid]==start+mid) {
            low=mid+1;
        }
        else {
            high=mid-1;
        }
    }
    return start+low;
}

int main() {
    int n;
    cout<<"Enter the size of array: ";
    cin>>n;
    cout<<endl;
    vector<int> arr(n);
    cout<<"Enter the elements of the array: ";
    for (int i=0; i<n; i++) {
        cin>>arr[i];
    }
    int ls = findMissingLinear(arr);
    cout<<"The missing element using linear search is: "<<ls<<endl;
    int bs = findMissingBinary(arr);
    cout<<"The missing element using binary search is: "<<bs<<endl;

    return 0;
}