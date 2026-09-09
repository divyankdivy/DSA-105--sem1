#include <iostream>
#include <stack>
using namespace std;

int main() {
    string str;
    stack<char> s;

    cout << "Enter a string: ";
    cin >> str;

    // Push all characters into stack
    for (int i = 0; i < str.length(); i++) {
        s.push(str[i]);
    }

    // Pop characters to get reverse string
    cout << "Reversed string: ";

    while (!s.empty()) {
        cout << s.top();
        s.pop();
    }

    return 0;
}