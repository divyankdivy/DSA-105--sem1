#include <iostream>
#include <vector>
using namespace std;

static void bSort(vector<int>& nums) {
    int n=nums.size();
    for (int i=0; i<n-1; i++) {
        int isSort=0;
        for (int j=0; j<n-1-i; j++) {
            if (nums[j]>nums[j+1]) {
                int temp=nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                isSort=1;
            }
        }
        if (isSort==0) {
            return;
        }
    }
}

int main() {
    vector<int> a = {64, 34, 25, 12, 22, 11,90};
    bSort(a);
    for (int i=0; i<a.size(); i++) {
        cout<<a[i]<<endl;
    }

    return 0;
}