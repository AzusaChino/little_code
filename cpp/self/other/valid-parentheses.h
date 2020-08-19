#include <stack>

class Solution {
public:
    bool isValid(string s) {
        stack<char> paren;
        for (char &c : s) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    paren.push(c);
                    break;
                case ')':
                    if (paren.empty() || paren.top() != '(') return false;
                    else paren.pop();
                    break;
                case '}':
                    if (paren.empty() || paren.top() != '{') return false;
                    else paren.pop();
                    break;
                case ']':
                    if (paren.empty() || paren.top() != '[') return false;
                    else paren.pop();
                    break;
                default:; // pass
            }
        }
        return paren.empty();
    }

private:
    bool isValid(string s) {
        stack<char> stk;
        for (const auto &c : s) {
            switch (c) {
                case '{':
                    stk.push('}');
                    break;
                case '[':
                    stk.push(']');
                    break;
                case '(':
                    stk.push(')');
                    break;
                default:
                    if (stk.size() == 0 || c != stk.top()) return false;
                    else stk.pop();
            }
        }
        return stk.size() == 0;
    }
}