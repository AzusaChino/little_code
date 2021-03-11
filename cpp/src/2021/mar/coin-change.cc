#include <vector>

using std::vector;
class CoinChange
{
public:
    int coinChange(vector<int> &coins, int amount)
    {
        int max = amount + 1;
        vector<int> dp(max, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
        {
            for (auto c : coins)
            {
                if (c <= i)
                {
                    dp[i] = min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};

int min(int a, int b)
{
    return a > b ? b : a;
}