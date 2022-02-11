#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> v;
        helper(v, "", 0, 0, n);
        return v;
    }

private:
    // using ref
    void helper(vector<string>& list, string str, int l, int r, int n) {
        if (str.size() == n << 1) {
            list.push_back(str);
            return;
        }

        if (l < n) {
            helper(list, str + "(", l + 1, r, n);
        }
        if (r < l) {
            helper(list, str + ")", l, r + 1, n);
        }
    }
};
