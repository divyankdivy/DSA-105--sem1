#include <algorithm>
#include <cctype>
#include <iostream>
using namespace std;

// Concatenate a string
string concatenate(string str1, string str2) {
    return str1 + " " + str2;
}

// Reverse a String
string reverseString(string str) {
    int n = str.length();

    for (int i=0; i<n/2; i++) {
        char temp = str[i];
        str[i] = str[n-i-1];
        str[n-i-1] = temp;
    }
    return str;
}

// Remove Vowels
string removeVowel(string str) {
    string result = "";

    for (int i=0; i<str.length(); i++) {

        char ch = tolower(str[i]);

        if (ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u') {
            result+=str[i];
        }
    }
    return result;
}

// Sorting a string
void stringSort(vector<string>& str) {
    int n=str.size();
    for (int i=0; i<n-1; i++) {
        for (int j=0; j<n-i-1; j++) {
            if (str[j]>str[j+1]) {
                string temp = str[j];
                str[j] = str[j+1];
                str[j+1] = temp;
            }
        }
    }
}

char convertToLower(char ch) {
    if (ch>='A' && ch<='Z') {
        ch = ch + 32;
    }
    return ch;
}

int main() {


    string str1, str2;

    cout << "Enter first string: ";
    cin >> str1;

    cout<<endl;

    cout << "Enter second string: ";
    cin >> str2;
    
    // String concatination
    string concatResult = concatenate(str1, str2);
    cout << "Concatenated string: " << concatResult<<endl;

    // Reverse a String
    string revResult = reverseString(str1);
    cout<<"Reversed Stirng: "<<revResult<<endl;

    // Delete Vowels from string
    string remVowelRes = removeVowel(str1);
    cout<<"Removed vowels String: "<<remVowelRes<<endl;

    // Sorting a string
    int n;
    cout<<"Enter the number of string: ";
    cin>>n;

    vector<string> str3(n);
    cout << "Enter the strings: ";

    for (int i=0; i<n; i++) {
        cin >> str3[i];
    }
    stringSort(str3);
    for (int i=0; i<n; i++) {
        cout<<str3[i]<<", ";
    }
    cout<<endl;

    // Convert Char to lowerCase
    char ch;

    cout << "Enter an uppercase character: ";
    cin >> ch;
    char result = convertToLower(ch);
    cout << "Lowercase character: " << result;

    return 0;
}