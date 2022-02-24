#include <vector>

using namespace std;
class Solution
{
public:
    int maxProduct(vector<int> &nums)
    {
        size_t sz = nums.size();
        int res = nums[0], l = 0, r = 0;
        for (auto i = 0; i < sz; ++i)
        {
            l = (l ? l : 1) * nums[i];
            r = (r ? r : 1) * nums[sz - i - 1];
            res = max(res, max(l, r));
        }
        return res;
    }
};