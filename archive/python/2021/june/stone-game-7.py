from typing import List
from itertools import accumulate


class Solution:
    def stoneGameVII(self, s: List[int]) -> int:
        dp = [[0] * len(s) for _ in range(len(s))]
        p_sum = [0] + list(accumulate(s))

        def dfs(i: int, j: int) -> int:
            if i == j:
                return 0
            if dp[i][j] == 0:
                sum = p_sum[j + 1] - p_sum[i]
                dp[i][j] = max(sum - s[i] - dfs(i + 1, j), sum - s[j] - dfs(i, j - 1))
            return dp[i][j]

        res = dfs(0, len(s) - 1)
        return res
