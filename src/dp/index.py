import sys
from typing import List
from statistics import mean


class Solution:
    def coinChange(self, coins: List[int], amount) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for i in range(1, amount):
            for c in coins:
                if i - c < 0:
                    continue
                dp[i] = min(dp[i], 1 + dp[i - c])

        return dp[amount] if dp[amount] != amount + 1 else -1

    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * n] * m
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[m - 1][n - 1]

    def lis(self, nums: List[int]) -> int:
        """
        dp[i] indicates the lis ends with i
        """
        N = len(nums)
        dp = [1] * N
        mx = 0
        for i in range(N):
            for j in range(i - 1, -1, -1):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
            mx = max(mx, dp[i])
        return mx

    def lcs(self, s, t):
        M, N = len(s), len(t)
        dp = [[0] * (N + 1)] * (M + 1)
        for i in range(1, M + 1):
            for j in range(N + 1):
                if s[i - 1] == t[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
        return dp[M][N]

    def lps(self, s: str) -> int:
        N = len(s)
        dp = [[0] * N] * N
        # base case
        for i in range(N):
            dp[i][i] = 1
        for i in range(N - 2, -1, -1):
            for j in range(i + 1, N):
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
        return dp[0][N - 1]

    def edit_distance(self, s, t):
        M, N = len(s), len(t)
        dp = [[0] * (N + 1)] * (M + 1)
        # base case
        for i in range(M + 1):
            dp[i][0] = i
        for j in range(N + 1):
            dp[0][j] = j
        for i in range(1, M + 1):
            for j in range(N + 1):
                if s[i - 1] == t[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
        return dp[M][N]

    def is_match(self, s: str, p: str) -> bool:
        pass

    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        N = len(nums)
        if N == 1:
            return nums[0]
        dp = [0] * (N + 1)
        for i in range(1, N):
            dp[i + 1] = max(dp[i], nums[i] + dp[i - 1])
        return dp[N]

    def superEggDrop(self, k, n):
        """
        k: egg count
        n: total floor
        """
        memo = dict()

        def dp(k, n) -> int:
            if k == 1:
                return n
            if n == 0:
                return 0
            if (k, n) in memo:
                return memo[(k, n)]
            ret = sys.maxsize
            for i in range(1, n + 1):
                # egg did not break, go up
                # egg did break, go down
                ret = min(ret, max(dp(k, n - i), dp(k - 1, i - 1)) + 1)
            memo[(k, n)] = ret
            return ret

        return dp(k, n)

    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        points = [1] + nums + [1]
        dp = [[0] * (n + 2) for _ in range(n + 2)]
        for i in range(n, -1, -1):
            # j 应该从左往右
            for j in range(i + 1, n + 2):
                # 最后戳破的气球是哪个？
                for k in range(i + 1, j):
                    # 择优做选择
                    dp[i][j] = max(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + points[i] * points[j] * points[k],
                    )
        return dp[0][n + 1]

    def knapsack(self, W: int, N: int, wt: List[int], val: List[int]) -> int:
        # 初始化一个二维数组，用于存储状态
        # dp[i][j] 表示将前 i 个物品装入容量为 j 的背包中所获得的最大价值
        dp = [[0] * (W + 1) for _ in range(N + 1)]
        # 开始进行递推
        for i in range(1, N + 1):
            for w in range(1, W + 1):
                if w < wt[i - 1]:
                    # 当前商品 i 的重量已经超过了 w，无法被放入当前容量为 w 的背包中，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w]
                else:
                    # 当前商品 i 的重量小于等于当前容量 w，可以尝试将其放入背包中
                    # 取最大值，考虑是将其放入之前的最优方案中还是选择不放
                    dp[i][w] = max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w])
        # 返回最大价值
        return dp[N][W]


if __name__ == "__main__":
    s = Solution()
    print(s.maxCoins([3, 1, 5, 8]))
