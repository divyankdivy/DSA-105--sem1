#include <iostream>
using namespace std;

static void bSort(vector<int>& nums) {
    int n = nums.size();
    for (int i=0; i<=n-1; i++) {
        for (int j=0; j<n-1-i; j++) {
            if (nums[j]>nums[j+1]) {
                int temp=nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
}

static int numsCount(vector<int> nums) {
    bSort(nums);
    int n=nums.size();
    if (n==0) {
        return 0;
    }
    int count=1;
    for (int i=1; i<n; i++) {
        if (nums[i]==nums[i-1]) {
            continue;
        }
        else {
            count++;
        }
    }
    return count;
}

int main() {
    vector<int> nums = {2, 3, 3, 2, 1, 1, 4, 1, 2, 3};
    int n=nums.size();
    for (int i=0; i<n; i++) {
        cout<<nums[i]<<" ";
    }
    int c = numsCount(nums);
    cout<<endl<<c;
    return 0;
}