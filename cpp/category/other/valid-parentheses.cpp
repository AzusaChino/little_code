#include <stack>
#include <string>

using namespace std;
class Solution
{
public:
    bool isValid(string s)
    {
        stack<char> parent;
        for (char &c : s)
        {
            switch (c)
            {
            case '(':
            case '{':
            case '[':
                parent.push(c);
                break;
            case ')':
                if (parent.empty() || parent.top() != '(')
                    return false;
                else
                    parent.pop();
                break;
            case '}':
                if (parent.empty() || parent.top() != '{')
                    return false;
                else
                    parent.pop();
                break;
            case ']':
                if (parent.empty() || parent.top() != '[')
                    return false;
                else
                    parent.pop();
                break;
            default:; // pass
            }
        }
        return parent.empty();
    }

private:
    bool isValid(string s)
    {
        stack<char> stk;
        for (const auto &c : s)
        {
            switch (c)
            {
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
                if (stk.size() == 0 || c != stk.top())
                    return false;
                else
                    stk.pop();
            }
        }
        return stk.size() == 0;
    }
};