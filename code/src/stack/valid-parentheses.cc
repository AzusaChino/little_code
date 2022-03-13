#include <common.h>
#include <stack>
#include <map>

class Solution
{
public:
    bool isValid(string s)
    {
        map<char, char> m;
        m[')'] = '(';
        m['}'] = '{';
        m[']'] = '[';
        stack<char> sk;
        for (int i = 0; i < s.size(); i++)
        {
            if (m[s[i]])
            {
                if (sk.empty())
                {
                    return false;
                }
                if (sk.top() != m[s[i]])
                {
                    return false;
                }
                else
                {
                    sk.pop();
                }
            }
            else
            {
                sk.push(s[i]);
            }
        }
        return sk.empty();
    }
};