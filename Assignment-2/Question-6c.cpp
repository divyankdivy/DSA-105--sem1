#include <iostream>
using namespace std;

void multiply(int A[][3], int B[][3], int C[][3]) {
    int k=1;

    for (int i=1; i<=A[0][2]; i++) {
        for (int j=1; j<=B[0][2]; j++) {

            if (A[i][1] == B[j][0]) {
                int row = A[i][0];
                int col = B[j][1];
                int value = A[i][2] * B[j][2];

                bool found = false;

                for (int x=1; x<k; x++) {
                    if (C[x][0] == row && C[x][1] == col) {
                        C[x][2] += value;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    C[k][0] = row;
                    C[k][1] = col;
                    C[k][2] = value;
                    k++;
                }
            }
        }
    }

    C[0][0] = A[0][0];
    C[0][1] = B[0][1];
    C[0][2] = k-1;
}

void display(int C[][3]) {
    for (int i=0; i<=C[0][2]; i++) {
        cout << C[i][0] << " "
             << C[i][1] << " "
             << C[i][2] << endl;
    }
}

int main() {

    int A[4][3] = {
        {2, 2, 3},
        {0, 0, 1},
        {0, 1, 2},
        {1, 1, 3}
    };

    int B[4][3] = {
        {2, 2, 3},
        {0, 0, 4},
        {0, 1, 5},
        {1, 1, 6}
    };

    int C[10][3];

    multiply(A, B, C);

    cout << "Multiplication of sparse matrices:" << endl;
    display(C);

    return 0;
}