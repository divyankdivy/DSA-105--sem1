#include <iostream>
using namespace std;

void add(int A[][3], int B[][3], int C[][3]) {
    int i=1, j=1, k=1;

    C[0][0] = A[0][0];
    C[0][1] = A[0][1];

    while (i<=A[0][2] && j<=B[0][2]) {

        if (A[i][0] == B[j][0] && A[i][1] == B[j][1]) {
            C[k][0] = A[i][0];
            C[k][1] = A[i][1];
            C[k][2] = A[i][2] + B[j][2];

            i++;
            j++;
            k++;
        }

        else if (A[i][0] < B[j][0] ||
                (A[i][0] == B[j][0] && A[i][1] < B[j][1])) {

            C[k][0] = A[i][0];
            C[k][1] = A[i][1];
            C[k][2] = A[i][2];

            i++;
            k++;
        }

        else {
            C[k][0] = B[j][0];
            C[k][1] = B[j][1];
            C[k][2] = B[j][2];

            j++;
            k++;
        }
    }

    while (i<=A[0][2]) {
        C[k][0] = A[i][0];
        C[k][1] = A[i][1];
        C[k][2] = A[i][2];
        i++;
        k++;
    }

    while (j<=B[0][2]) {
        C[k][0] = B[j][0];
        C[k][1] = B[j][1];
        C[k][2] = B[j][2];
        j++;
        k++;
    }

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

    int A[5][3] = {
        {3, 3, 4},
        {0, 0, 1},
        {1, 1, 2},
        {1, 2, 3},
        {2, 2, 4}
    };

    int B[5][3] = {
        {3, 3, 4},
        {0, 0, 5},
        {1, 1, 6},
        {1, 2, 7},
        {2, 2, 8}
    };

    int C[9][3];

    add(A, B, C);

    cout << "Addition of sparse matrices:" << endl;
    display(C);

    return 0;
}