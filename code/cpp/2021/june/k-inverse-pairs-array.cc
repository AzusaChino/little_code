#include <vector>

using namespace std;

class Solution {
public:
    int kInversePairs(int n, int k) {
        int                 m = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j <= k; j++)
                for (int p = 0; j + p <= min(k, j + i - 1); p++)
                    dp[i][j + p] = (dp[i][j + p] + dp[i - 1][j]) % m;

        return dp[n][k] % m;
    }
};
