#include "common.h"

class Solution
{
public:
    int deleteAndEarn(vector<int> &nums)
    {
        int n = 10001;
        vector<int> values(n, 0);
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++)
        {
            int take_i = skip + values[i];
            int skip_i = max(skip, take);
            take = take_i;
            skip = skip_i;
        }
        return max(take, skip);
    }
};