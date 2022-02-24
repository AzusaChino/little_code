#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProduct(vector<string>& words) {
        vector<int> mask(words.size());
        int         result = 0;
        for (int i = 0; i < words.size(); ++i) {
            for (char c : words[i]) mask[i] |= 1 << (c - 'a');
            for (int j = 0; j < i; ++j)
                if (!(mask[i] & mask[j]))
                    result =
                        max(result, int(words[i].size() * words[j].size()));
        }
        return result;
    }

    int _maxProduct(vector<string>& words) {
        unordered_map<int, int> maxlen;
        int                     result = 0;
        for (string word : words) {
            int mask = 0;
            for (char c : word) mask |= 1 << (c - 'a');
            maxlen[mask] = max(maxlen[mask], (int)word.size());
            for (auto maskAndLen : maxlen)
                if (!(mask & maskAndLen.first))
                    result = max(result, (int)word.size() * maskAndLen.second);
        }
        return result;
    }
};