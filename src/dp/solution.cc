#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    int longestCommonSubsequence(string text1, string text2)
    {
        int m = text1.size(), n = text2.size();
        int dp[m + 1][n + 1];
        memset(dp, 0, sizeof(dp));

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (text1[i - 1] == text2[j - 1])
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    int minDistance(string word1, string word2)
    {
        int m = word1.size(), n = word2.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));

        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // 自底向上求解
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (word1[i - 1] == word2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c)
    {
        return std::min(a, std::min(b, c));
    }

    int mod = pow(10, 9) + 7;

    int findPaths(int m, int n, int N, int i, int j)
    {
        vector<vector<vector<int>>> dp(N + 1, vector<vector<int>>(m + 1, vector<int>(n + 1, -1)));
        dp[N][m][n] = helperFunction(m, n, N, i, j, 0, dp);
        return dp[N][m][n];
    }

    int helperFunction(int row, int col, int maxMoves, int x, int y, int moves, vector<vector<vector<int>>> &dp)
    {
        // out of boundary
        if (x < 0 || y < 0 || x >= row || y >= col)
        {
            return 1;
        }
        // no more step
        if (moves == maxMoves)
        {
            return 0;
        }
        if (dp[moves][x][y] != -1)
        {
            return dp[moves][x][y] % mod;
        }
        int tempVal = 0;
        tempVal = (tempVal + helperFunction(row, col, maxMoves, x, y - 1, moves + 1, dp)) % mod;
        tempVal = (tempVal + helperFunction(row, col, maxMoves, x - 1, y, moves + 1, dp)) % mod;
        tempVal = (tempVal + helperFunction(row, col, maxMoves, x + 1, y, moves + 1, dp)) % mod;
        tempVal = (tempVal + helperFunction(row, col, maxMoves, x, y + 1, moves + 1, dp)) % mod;
        dp[moves][x][y] = tempVal;
        return dp[moves][x][y] % mod;
    }

    int numSquares(int n)
    {
        vector<int> dp(n + 1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
        {
            // wrost case, all of 1
            dp[i] = i;
            for (int j = 1; j * j <= i; j++)
            {
                dp[i] = std::min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    int coinChange(vector<int> &coins, int amount)
    {
        vector<int> dp(amount + 1, amount + 1);
        dp[0] = 0;

        std::sort(coins.begin(), coins.end());

        for (int i = 1; i <= amount; i++)
        {
            for (int c : coins)
            {
                if (i < c)
                {
                    break;
                }
                if (dp[i - c] != amount + 1)
                {
                    dp[i] = std::min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // 数组排序，这道题就变成了 动态规划设计：最长递增子序列。
    vector<int> largestDivisibleSubset(vector<int> &nums)
    {
        int n = nums.size();
        std::sort(nums.begin(), nums.end());
        vector<vector<int>> dp(n, vector<int>());
        // base case
        dp[0].push_back(nums[0]);

        for (int i = 1; i < n; i++)
        {
            int maxSubSetLen = 0, index = -1;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] % nums[j] == 0 && dp[j].size() > maxSubSetLen)
                {
                    maxSubSetLen = dp[j].size();
                    index = j;
                }
            }
            if (index != -1)
            {
                dp[i] = dp[index];
            }
            dp[i].push_back(nums[i]);
        }
        vector<int> res = dp[0];
        for (int i = 1; i < n; i++)
        {
            if (res.size() < dp[i].size())
            {
                res = dp[i];
            }
        }
        return res;
    }
};