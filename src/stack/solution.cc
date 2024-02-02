#include <stack>
#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
  int evalRPN(vector<string> &tokens)
  {
    stack<int> s;
    string pattern = "+-*/";
    for (const string &token : tokens)
    {
      if (pattern.find(token) != string::npos)
      {
        int a = s.top();
        s.pop();
        int b = s.top();
        s.pop();
        switch (token[0])
        {
        case '+':
          s.push(a + b);
          break;
        case '*':
          s.push(a * b);
          break;
        case '-':
          s.push(b - a);
          break;
        case '/':
          s.push(b / a);
          break;
        }
      }
      else
      {
        int i = std::stoi(token);
        s.push(i);
      }
    }
    return s.top();
  }

  vector<int> dailyTemperatures(vector<int> &temperatures)
  {
    stack<int> st;
    int n = temperatures.size();
    vector<int> res(n, 0);
    for (auto i = n - 1; i >= 0; i--)
    {
      while (!st.empty() && temperatures[st.top()] <= temperatures[i])
      {
        st.pop();
      }
      if (!st.empty())
      {
        res[i] = st.top() - i;
      }
      st.push(i);
    }

    return res;
  }
};
