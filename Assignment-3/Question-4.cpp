#include <iostream>
#include <stack>
using namespace std;

int priority(char ch) {
    if (ch == '+' || ch == '-')
        return 1;
    if (ch == '*' || ch == '/')
        return 2;

    return 0;
}

int main() {
    string infix;
    stack<char> s;

    cout << "Enter infix expression: ";
    cin >> infix;

    cout << "Postfix expression: ";

    for (int i = 0; i < infix.length(); i++) {

        // If operand
        if ((infix[i] >= 'a' && infix[i] <= 'z') ||
            (infix[i] >= 'A' && infix[i] <= 'Z')) {

            cout << infix[i];
        }

        // If opening bracket
        else if (infix[i] == '(') {
            s.push(infix[i]);
        }

        // If closing bracket
        else if (infix[i] == ')') {
            while (!s.empty() && s.top() != '(') {
                cout << s.top();
                s.pop();
            }

            s.pop();
        }

        // If operator
        else {
            while (!s.empty() && priority(s.top()) >= priority(infix[i])) {
                cout << s.top();
                s.pop();
            }

            s.push(infix[i]);
        }
    }

    // Print remaining operators
    while (!s.empty()) {
        cout << s.top();
        s.pop();
    }

    return 0;
}