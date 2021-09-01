#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        int          res = 0, n = nums.size();
        vector<bool> seen(n);
        for (int i : nums) {
            int cnt = 0;
            while (!seen[i]) {
                seen[i] = true;
                cnt++;
                i = nums[i];
            }
            res = max(res, cnt);
        }
        return res;
    }
};
