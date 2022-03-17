#include "common.h"
#include <stack>

class Solution
{
public:
    int scoreOfParentheses(string s)
    {
        stack<int> st;
        int cur = 0;
        for (char c : s)
        {
            if (c == '(')
            {
                st.push(cur);
                cur = 0;
            }
            else
            {
                cur += st.top() + max(cur, 1);
                st.pop();
            }
        }
        return cur;
    }

    int _scoreOfParentheses(string s)
    {
        int res[30] = {0}, i = 0;
        for (char c : s)
            if (c == '(')
                res[++i] = 0;
            else
                res[i - 1] += max(res[i] * 2, 1), i--;
        return res[0];
    }

    int __scoreOfParentheses(string s)
    {
        int res = 0, l = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (s[i] == '(')
                l++;
            else
                l--;
            if (s[i] == ')' && s[i - 1] == '(')
                res += 1 << l;
        }
        return res;
    }
};