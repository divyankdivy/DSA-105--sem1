#include <iostream>
#include <stack>
using namespace std;

int main() {
    string postfix;
    stack<int> s;

    cout << "Enter postfix expression: ";
    cin >> postfix;

    for (int i = 0; i < postfix.length(); i++) {

        // If digit, push into stack
        if (postfix[i] >= '0' && postfix[i] <= '9') {
            s.push(postfix[i] - '0');
        }

        // If operator
        else {
            int b = s.top();
            s.pop();

            int a = s.top();
            s.pop();

            if (postfix[i] == '+')
                s.push(a + b);

            else if (postfix[i] == '-')
                s.push(a - b);

            else if (postfix[i] == '*')
                s.push(a * b);

            else if (postfix[i] == '/')
                s.push(a / b);
        }
    }

    cout << "Result: " << s.top();

    return 0;
}