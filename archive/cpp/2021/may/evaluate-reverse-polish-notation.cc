#include <functional>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        unordered_map<string, function<int(int, int)>> map = {
            {"+", [](int a, int b) { return a + b; }},
            {"-", [](int a, int b) { return a - b; }},
            {"*", [](int a, int b) { return a * b; }},
            {"/", [](int a, int b) { return a / b; }}};
        stack<int> stack;
        for (string& s : tokens) {
            if (!map.count(s)) {
                stack.push(stoi(s));
            } else {
                int op1 = stack.top();
                stack.pop();
                int op2 = stack.top();
                stack.pop();
                stack.push(map[s](op2, op1));
            }
        }
        return stack.top();
    }

private:
    int _evalRPN(vector<string>& tokens) {
        stack<int>                                     s;
        unordered_map<string, function<int(int, int)>> map{
            {"+", std::plus<int>()},
            {"-", std::minus<int>()},
            {"*", std::multiplies<int>()},
            {"/", std::divides<int>()}};

        for (const auto& token : tokens) {
            const auto& op = map.find(token);
            if (op != map.end()) {
                //  assert(s.size() >= 2);
                int rhs = s.top();
                s.pop();
                int lhs = s.top();
                s.pop();
                s.push((*op).second(lhs, rhs));
            } else {
                s.push(stoi(token));
            }
        }

        // assert(s.size() == 1);
        return s.top();
    }
};