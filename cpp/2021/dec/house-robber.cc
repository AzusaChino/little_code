#include <vector>

using namespace std;

class Solution
{
public:
    int rob(vector<int> &nums)
    {
        size_t sz = nums.size();
        int pre = 0, cur = 0;
        for (auto i = 0; i < sz; ++i)
        {
            auto temp = max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
};