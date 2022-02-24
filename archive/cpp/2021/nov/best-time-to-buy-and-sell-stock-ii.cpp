#include <vector>

using namespace std;

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int ret = 0;
        for (size_t i = 1; i < prices.size(); ++i)
        {
            ret += max(prices[i] - prices[i - 1], 0);
        }
        return ret;
    }
};