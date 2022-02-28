#include "common.h"

class Solution
{
public:
    vector<string> summaryRanges(vector<int> &nums)
    {
        vector<string> ret;
        for (int i = 0, n = nums.size(); i < n; i++)
        {
            int begin = nums[i];
            while (i != (n - 1) && nums[i] == nums[i + 1] - 1)
                i++;
            int end = nums[i];
            if (begin == end)
                ret.push_back(to_string(begin));
            else
                ret.push_back(to_string(begin) + "->" + to_string(nums[i]));
        }
        return ret;
    }
};