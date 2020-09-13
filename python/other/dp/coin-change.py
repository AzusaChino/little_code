class Solution:
    def coin_change(self, coins, target):
        dp = [target + 1 for _ in range(target + 1)]
        dp[0] = 0
        for i in range(1, target + 1):
            for c in coins:
                if c <= i:
                    dp[i] = min(dp[i], dp[i - c] + 1)
        return dp[target]


if __name__ == '__main__':
    s = Solution()
    print(s.coin_change([1, 2, 5], 11))
