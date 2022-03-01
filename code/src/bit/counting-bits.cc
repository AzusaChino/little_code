#include "common.h"

class Solution
{
public:
    vector<int> countBits(int n)
    {
        vector<int> ret(n + 1, 0);
        for (int i = 0; i <= n; ++i)
        {
            ret[i] = ret[i & (i - 1)] + 1;
            // res[i] = res[i >> 1] + (i & 1);
        }
        return ret;
    }
};