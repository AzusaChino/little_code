#include <string>

using namespace std;

int min_distance(string s, string t)
{
    int m = s.size(), n = t.size();
    int dp[m + 1][n + 1];
    for (auto i = 0; i <= m; i++)
    {
        dp[i][0] = i;
    }
    for (auto j = 0; j <= n; j++)
    {
        dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++)
    {
        for (int j = 1; i <= n; j++)
        {
            if (s[i - 1] == t[j - 1])
            {
                // keep
                dp[i][j] = dp[i - 1][j - 1];
            }
            else
            {
                // replace, delete, add
                dp[i][j] = 1 + min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
    }

    return dp[m][n];
}