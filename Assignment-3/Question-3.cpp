#include <iostream>
#include <stack>
using namespace std;

int main() {
    string str;
    stack<char> s;

    cout << "Enter expression: ";
    cin >> str;

    for (int i = 0; i < str.length(); i++) {
        if (str[i] == '(') {
            s.push('(');
        }

        else if (str[i] == ')') {
            if (s.empty()) {
                cout << "Not Balanced";
                return 0;
            }

            s.pop();
        }
    }

    if (s.empty())
        cout << "Balanced";
    else
        cout << "Not Balanced";

    return 0;
}