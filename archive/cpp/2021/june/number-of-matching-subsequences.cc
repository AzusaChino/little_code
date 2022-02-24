#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        int                                 cnt = 0;
        unordered_map<char, vector<string>> m;
        for (auto& word : words) m[word.back()].push_back(word);
        for (int i = s.size() - 1; i >= 0; --i) {
            char c      = s[i];
            auto bucket = m[c];
            m[c].clear();
            for (auto& word : bucket) {
                word.pop_back();
                if (word.empty())
                    ++cnt;
                else
                    m[word.back()].push_back(word);
            }
        }
        return cnt;
    }
};
