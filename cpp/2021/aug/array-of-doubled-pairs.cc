#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    bool canReorderDoubled(vector<int>& nums) {
        unordered_map<int, int> m;
        for (int n : nums) {
            m[n]++;
        }
        vector<int> keys;
        for (auto it : m) {
            keys.push_back(it.first);
        }
        sort(keys.begin(), keys.end(),
             [](int i, int j) { return abs(i) < abs(j); });
        for (int k : keys) {
            if (m[k] > m[2 * k]) {
                return false;
            }
            m[2 * k] -= m[k];
        }
        return true;
    }
};
