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
};
