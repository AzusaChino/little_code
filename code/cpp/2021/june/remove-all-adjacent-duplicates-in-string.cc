#include <string>

using namespace std;

class Solution {
public:
    string removeDuplicates(string s) {
        int i = 0, n = s.size();
        for (int j = 0; j < n; ++j, ++i) {
            s[i] = s[j];
            if (i > 0 && s[i - 1] == s[i]) {
                i -= 2;
            }
        }
        return s.substr(0, i);
    }

    string _removeDuplicates(string S) {
        string res = "";
        for (char& c : S)
            if (res.size() && c == res.back())
                res.pop_back();
            else
                res.push_back(c);
        return res;
    }
};
