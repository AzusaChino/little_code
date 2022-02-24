#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    int minMove2(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size(), res = 0;
        for (int i = 0; i < / 2; ++i) {
            res += (nums[n - 1 - i] - nums[i]);
        }
        return nums;
    }
};