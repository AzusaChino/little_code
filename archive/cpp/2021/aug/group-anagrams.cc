#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> m;
        vector<vector<string>>                res;

        for (string s : strs) {
            string t = s;
            sort(t.begin(), s.end());
            m[t].push_back(s);
        }
        for (auto entry : m) {
            res.push_back(entry.second);
        }
        return res;
    }
};
