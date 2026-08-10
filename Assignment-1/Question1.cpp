#include <iostream>
using namespace std;

// Develop a Menu driven program to demonstrate the following operations of Arrays

// 1. CREATE
int nums[50];
int n=0;
static void createArr() {
    cout<<"Enter length of Array"<<endl;
    cin>>n;
    if (n <= 0 || n > 50) {
        cout << "Invalid length! Must be between 1 and 50." << endl;
        n = 0;
        return;
    }

    for (int i=0; i<n; i++) {
        nums[i] = 0;
    }
    cout<<"Array is created of size: "<<n<<endl;
}

// 2. DISPLAY
static void display() {

    if (n==0) {
        cout<<"Array is empty"<<endl;
        return;
    }

    for (int i=0; i<n; i++) {
        cout<<nums[i]<<", ";
    }
}

// 3. INSERT
static void insertEl() {

    if (n == 0) {
        cout << "Array is currently empty!" << endl;
    }

    if (n >= 50) {
        cout << "Array is full! Dropping the last element to make space." << endl;
        n = 49; 
    }
    int el, pos;
    cout<<"Enter the element you want to insert: "<<endl;
    cin>>el;
    cout<<"Enter the index from (0 to "<<n<<"): "<<endl;
    cin>>pos;

    if (pos<0 || pos>n) {
        cout<<"Invalid index position."<<endl;
        return;
    }

    for (int i=n; i>pos; i--) {
        nums[i]=nums[i-1];
    }

    nums[pos] = el;
    n++;
}

// 4. DELETE
static void deleteEl() {
    if (n==0) {
        cout<<"Array is empty"<<endl;
        return;
    }
    int pos;
    cout<<"Enter the index position to delete from (0 to "<<n-1<<"): "<<endl;
    cin>>pos;
    if (pos<0 || pos>=n) {
        cout<<"Invalid index position"<<endl;
        return;
    }
    
    for (int i=pos; i<n-1; i++) {
        nums[i] = nums[i+1];
    }

    n--;
    cout<<"Element deleted successfully"<<endl;

}

// 5. LINEAR SEARCH
static void linearSearch() {
    int num;
    cout<<"Enter the number you want to find:"<<endl;
    cin>>num;
    for (int i=0; i<n; i++) {
        if (nums[i]==num) {
            cout<<"Element is found on the index: "<<i<<endl;
            return;
        }
    }
    cout<<"Element not found"<<endl;
}

int main() {

    int choice;

    while (true) {
        // MENU
        cout<<"\n--MENU--"<<endl;
        cout<<"1. CREATE Array"<<endl;
        cout<<"2. Display Array"<<endl;
        cout<<"3. Insert In Array"<<endl;
        cout<<"4. Delete In Array"<<endl;
        cout<<"5. Linear Search"<<endl;
        cout<<"6. Exit"<<endl;
        cout<<"Enter your choice: ";
        cin>>choice;

        switch (choice) {
            case 1: {
                createArr();
                break;
            }
            case 2: {
                display();
                break;
            }
            case 3: {
                insertEl();
                break;
            }
            case 4: {
                deleteEl();
                break;
            }
            case 5: {
                linearSearch();
                break;
            }

            case 6: {
                return 0;
            }
            default: {
                cout<<"Invalid choice try again";
            }
        }
    }
}