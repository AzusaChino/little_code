import sys
from typing import List


class StockSolution:
    """
    dp[i][k][1|0]
    i: day
    k: at most transactions
    状态 k 的定义并不是「已进行的交易次数」，而是「最大交易次数的上限限制」。
    如果确定今天进行一次交易, 且要保证截至今天最大交易次数上限为 k, 那么昨天的最大交易次数上限必须是 k - 1。
    1/0: whether hold stock
    """

    def maxProfit1(self, prices: List[int]) -> int:
        """
        121, allow one transaction
        """
        N = len(prices)
        dp = [[0] * 2 for _ in range(N)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1, N):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            # only allow buy once
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        return dp[-1][0]

    def maxProfit2(self, prices: List[int]) -> int:
        """
        122, allow multiple times transaction
        """
        N = len(prices)
        if N < 2:
            return 0
        dp = [[0] * 2 for _ in range(N)]
        # base case
        dp[0][0] = 0
        dp[0][1] = -prices[0]

        dp[1][0] = max(0, dp[0][1] + prices[1])
        dp[1][1] = max(dp[0][1], -prices[1])
        for i in range(2, N):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            # allow buy multiple times
            dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
        return dp[-1][0]

    def maxProfit_withCool(self, prices: List[int]) -> int:
        """
        309
        """
        N = len(prices)
        dp = [[0] * 2 for _ in range(N)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1, N):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            # allow buy multiple times
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        return dp[-1][0]

    def maxProfit_withFee(self, prices: List[int], fee: int) -> int:
        """
        714
        """
        N = len(prices)
        dp = [[0] * 2 for _ in range(N)]
        dp[0][0] = 0
        dp[0][1] = -prices[0] - fee
        for i in range(1, N):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            # multiple times buy but with fee
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
        return dp[-1][0]

    def maxProfit(self, prices: List[int], k: int) -> int:
        N = len(prices)
        if N <= 0:
            return 0
        if k > N // 2:
            # no transaction limits
            return self.maxProfit2(prices)
        dp = [[[0] * 2 for _ in range(k + 1)] for _ in range(N + 1)]

        # base case
        for kk in range(k, 0, -1):
            dp[0][kk][0] = 0
            dp[0][kk][1] = -prices[0]
        for i in range(N):
            dp[i][0][0] = 0
            dp[i][0][1] = -sys.maxsize

        for i in range(N):
            for kk in range(k, 0, -1):
                dp[i][kk][0] = max(dp[i - 1][kk][0], dp[i - 1][kk][1] + prices[i])
                dp[i][kk][1] = max(dp[i - 1][kk][1], dp[i - 1][k - 1][0] - prices[i])

        return dp[-1][k][0]
