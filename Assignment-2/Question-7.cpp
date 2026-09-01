#include <iostream>
#include <vector>
using namespace std;

int countInversions(vector<int>& arr) {
    int count=0;

    for (int i=0; i<arr.size()-1; i++) {
        for (int j=i+1; j<arr.size(); j++) {
            if (arr[i]>arr[j]) {
                count++;
            }
        }
    }
    return count;
}

int main() {
    int n;

    cout << "Enter the size of array: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter the elements of array: ";
    for (int i=0; i<n; i++) {
        cin >> arr[i];
    }

    int result = countInversions(arr);

    cout << "Number of inversions: " << result;

    return 0;
}