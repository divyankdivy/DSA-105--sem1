#include <iostream>
#include <set>
using namespace std;

// Design the logic to remove the duplicate elements from an Array and after the
// deletion the array should contain the unique elements.

static void removeDuplicateNestedLoop(int nums[], int &n) {
    for (int i=0; i<n; i++) {
        for (int j=i+1; j<n; j++) {
            if (nums[j]==nums[i]) {
                for (int k=j; k<n-1; k++) {
                    nums[k] = nums[k+1];
                }
                n--;
                j--;
            }
        }
    }
    cout<<"Duplicates removed"<<endl;
}

static void removeDuplicatesSet(int nums[], int &n) {

    if (n==0) {
        cout<<"Array is empty"<<endl;
        return;
    }
    set<int> st;
    
    for (int i=0; i<n; i++) {
        st.insert(nums[i]);
    }
    int index=0;
    for (int x: st) {
        nums[index]=x;
        index++;
    }

    n=st.size();

    cout<<"Duplicates have been removed successfully"<<endl;
}

int main() {

    int arr[] = {4, 2,5, 5, 5,2, 4, 4, 8, 2, 4, 3, 8, 12};
    int n=sizeof(arr)/sizeof(arr[0]);
    for (int i=0; i<n; i++) {
        cout<<arr[i]<<", ";
    }
    cout<<endl;
    removeDuplicatesSet(arr, n);
    for (int i=0; i<n; i++) {
        cout<<arr[i]<<", ";
    }

    return 0;
}