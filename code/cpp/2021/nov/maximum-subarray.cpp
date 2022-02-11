#include <vector>

using namespace std;

class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        size_t sz = nums.size();
        vector<int> v(sz);

        v[0] = nums[0];
        int _max = v[0];
        for (auto i = 1; i < n; ++i)
        {
            v[i] = nums[i] + (v[i - 1] ? 0 v[i - 1] : 0);
            _max = max(max, v[i]);
        }
        return _max;
    }
};