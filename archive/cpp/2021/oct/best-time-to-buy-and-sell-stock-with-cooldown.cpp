#include <vector>
#include "limits.h"

using namespace std;

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        size_t sz = prices.size();
        if (sz <= 1)
        {
            return 0;
        }
        vector<int> s0(sz, 0);
        vector<int> s1(sz, 0);
        vector<int> s2(sz, 0);

        s1[0] = -prices[0];
        s0[0] = 0;
        s2[0] = INT_MIN;

        for (auto i = 1; i < sz; ++i)
        {
            s0[i] = max(s0[i - 1], s2[i - 1]);
            s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return max(s0[sz - 1], s2[sz - 1]);
    }
};