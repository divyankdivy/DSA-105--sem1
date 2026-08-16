#include <iostream>
using namespace std;

void reverseArray(int nums[], int n) {
    int low=0, high=n-1;
    while (low<high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
        low++;
        high--;
    }
}

int main() {
    int nums[] = {1, 2, 3, 4, 5, 6};
    int n=sizeof(nums)/sizeof(nums[0]);
    reverseArray(nums, n);
    for (int num: nums) {
        cout<<num<<" ";
    }
}