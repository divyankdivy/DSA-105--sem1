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

// Function to find sum of every row
void rowSum(int** matrix, int rows, int cols){
    for (int i = 0; i < rows; i++){
        int sum = 0;
        for (int j = 0; j < cols; j++){
            sum += matrix[i][j];
        }
        cout << "Sum of row " << i + 1 << " = " << sum << endl;
    }
}

// Function to find sum of every column
void columnSum(int** matrix, int rows, int cols){
    for (int j = 0; j < cols; j++){
        int sum = 0;
        for (int i = 0; i < rows; i++){
            sum += matrix[i][j];
        }
        cout << "Sum of column " << j + 1 << " = " << sum << endl;
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

    // Create matrix
    int** matrix = createMatrix(rows, cols);

    // Input matrix
    inputMatrix(matrix, rows, cols);

    // Display matrix
    cout << "\nMatrix:\n";
    displayMatrix(matrix, rows, cols);

    // Find row sums
    cout << "\nRow Sums:\n";
    rowSum(matrix, rows, cols);

    // Find column sums
    cout << "\nColumn Sums:\n";
    columnSum(matrix, rows, cols);

    // Free memory
    deleteMatrix(matrix, rows);
    return 0;
}