#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words,
                                         string          pattern) {
        vector<string> res;
        for (auto itr = words.begin(); itr != words.end(); ++itr) {
            if (isSamePattern(*itr, pattern)) {
                res.push_back(*itr);
            }
        }
        return res;
    }

private:
    bool isSamePattern(string& word, string& pattern) {
        if (word.size() != pattern.size()) {
            return false;
        }
        unordered_map<char, char> map;
        for (int i = 0; i < word.size(); ++i) {
            char w = word[i];
            char p = pattern[i];
            if (!map[w]) {
                map[w] = p;
            }
            if (map[w] != p) {
                return false;
            }
        }
        // 初始化
        bool seen[26]{};
        for (auto itr = map.begin(); itr != map.end(); ++itr) {
            if (seen[itr->second - 'a']) {
                return false;
            }
            seen[itr->second - 'a'] = true;
        }

        return true;
    }
};