#include <iostream>
using namespace std;

void transpose(int sparse[5][3]) {
    cout << "Transpose:" << endl;

    for (int i=0; i<3; i++) {
        for (int j=0; j<5; j++) {
            if (i==0) {
                cout << sparse[j][i] << " ";
            }
            else {
                cout << sparse[j][i] << " ";
            }
        }
        cout << endl;
    }
}

int main() {

    // Triplet: row, column, value
    int sparse[5][3] = {
        {3, 3, 4},
        {0, 0, 1},
        {1, 1, 2},
        {1, 2, 3},
        {2, 2, 4}
    };

    transpose(sparse);

    return 0;
}