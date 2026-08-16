#include <iostream>
using namespace std;

// Function to create a matrix
int** createMatrix(int rows, int cols){
    int** matrix = new int*[rows];
    for (int i = 0; i < rows; i++){
        matrix[i] = new int[cols];
    }
    return matrix;
}

// Function to input elements of a matrix
void inputMatrix(int** matrix, int rows, int cols){
    cout << "Enter elements of the matrix:\n";
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            cin >> matrix[i][j];
        }
    }
}

// Function to find transpose of a matrix
void transposeMatrix(int** matrix, int** transpose, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            transpose[j][i] = matrix[i][j];
        }
    }
}

// Function to display a matrix
void displayMatrix(int** matrix, int rows, int cols){
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

int main(){
    int rows, cols;

    // Input dimensions of matrix
    cout << "Enter rows of matrix: ";
    cin >> rows;
    cout << "Enter columns of matrix: ";
    cin >> cols;

    // Create original matrix
    int** matrix = createMatrix(rows, cols);

    // Transpose will have columns x rows
    int** transpose = createMatrix(cols, rows);

    // Input matrix
    cout << "\nMatrix:\n";
    inputMatrix(matrix, rows, cols);

    // Find transpose
    transposeMatrix(matrix, transpose, rows, cols);

    // Display original matrix
    cout << "\nOriginal Matrix:\n";
    displayMatrix(matrix, rows, cols);

    // Display transpose
    cout << "\nTranspose Matrix:\n";
    displayMatrix(transpose, cols, rows);

    // Free memory
    deleteMatrix(matrix, rows);
    deleteMatrix(transpose, cols);
    return 0;

}