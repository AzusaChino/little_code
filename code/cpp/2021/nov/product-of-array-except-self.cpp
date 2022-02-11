#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> productExceptSelf(vector<int> &nums)
    {
        size_t sz = nums.size();
        int fromBegin = 1, fromEnd = 1;
        vector<int> res(sz, 1);

        for (auto i = 0; i < sz; ++i)
        {
            res[i] *= fromBegin;
            fromBegin *= nums[i];
            res[sz - 1 - i] *= fromEnd;
            fromEnd *= nums[sz - 1 - i];
        }
        return res;
    }
};