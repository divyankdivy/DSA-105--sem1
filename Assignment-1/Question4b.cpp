#include <iostream>
using namespace std;

// Function to create Matrix
int** createMatrix(int rows, int cols){
    int** matrix = new int*[rows];
    for (int i = 0; i < rows; i++) {
        matrix[i] = new int[cols];
    }
    return matrix;
}

// Function to input elements of a matrix

void inputMatrix(int** matrix, int rows, int cols) {
    cout << "Enter elements of the matrix:\n";
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++) {
            cin >> matrix[i][j];
        }
    }
}

// Function to multiply two matrices
void multiplyMatrix(int** A, int** B, int** C, int r1, int c1, int c2){
    for (int i = 0; i < r1; i++){
        for (int j = 0; j < c2; j++){
            C[i][j] = 0;
            for (int k = 0; k < c1; k++){
                C[i][j] += A[i][k] * B[k][j];
            }
        }
    }
}

// Function to display a matrix
void displayMatrix(int** matrix, int rows, int cols) {
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}

// Function to free memory

void deleteMatrix(int** matrix, int rows){
    for (int i = 0; i < rows; i++){
        delete[] matrix[i];
    }
    delete[] matrix;
}

int main() {
    int r1, c1;
    int r2, c2;

    // Input dimensions of first matrix
    cout << "Enter rows of first matrix: ";
    cin >> r1;
    cout << "Enter columns of first matrix: ";
    cin >> c1;

    // Rows of second matrix must equal columns of first matrix
    r2 = c1;
    cout << "Rows of second matrix = " << r2 << endl;
    cout << "Enter columns of second matrix: ";
    cin >> c2;

    // Create matrices
    int** A = createMatrix(r1, c1);
    int** B = createMatrix(r2, c2);

    // Result matrix will be r1 x c2
    int** C = createMatrix(r1, c2);

    // Input matrices
    cout << "\nFirst Matrix:\n";
    inputMatrix(A, r1, c1);
    cout << "\nSecond Matrix:\n";
    inputMatrix(B, r2, c2);

    // Multiply matrices
    multiplyMatrix(A, B, C, r1, c1, c2);

    // Display matrices
    cout << "\nFirst Matrix:\n";
    displayMatrix(A, r1, c1);
    cout << "\nSecond Matrix:\n";
    displayMatrix(B, r2, c2);
    cout << "\nResultant Matrix:\n";
    displayMatrix(C, r1, c2);

    // Free memory
    deleteMatrix(A, r1);
    deleteMatrix(B, r2);
    deleteMatrix(C, r1);
    
    return 0;
}