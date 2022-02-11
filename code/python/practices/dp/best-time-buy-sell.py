class Solution:
    # 可以交易无限次
    def max_profit(self, prices):
        if not prices: return 0
        ret = 0
        profit = [[0 for _ in range(3)] for _ in range(len(prices))]
        profit[0][0], profit[0][1], profit[0][1] = 0, -prices[0], 0
        for i in range(1, len(prices)):
            # 无操作
            profit[i][0] = profit[i - 1][0]
            # 买入股票
            profit[i][1] = max(profit[i - 1][1], profit[i - 1][0] - prices[i])
            # 卖出股票
            profit[i][2] = profit[i - 1][i] + prices[i]
            # 每次更新最大利润
            ret = max(profit[i][0], profit[i][1], profit[i][2])
        return ret

    # 最多交易两次
    def max_profit2(self, prices):
        if not prices: return 0
        profit = [[[0 for _ in range(2)] for _ in range(3)] for _ in range(len(prices))]
        # 初始条件(无操作|买入一股)
        profit[0][0][0], profit[0][0][1] = 0, -prices[0]
        profit[0][1][0], profit[0][1][1] = 0, 0
        profit[0][2][0], profit[0][2][1] = 0, 0

        for i in range(1, len(prices)):
            profit[i][0][0] = profit[i - 1][0][0]
            profit[i][0][1] = max(profit[i - 1][0][1], profit[i - 1][0][0] - prices[i])

            profit[i][1][0] = max(profit[i - 1][1][0], profit[i - 1][1][1] + prices[i])
            profit[i][1][1] = max(profit[i - 1][1][1], profit[i - 1][1][0] - prices[i])

            profit[i][2][0] = max(profit[i - 1][2][0], profit[i - 1][1][1] + prices[i])

        end = len(prices) - 1
        return max(profit[end][0][0], profit[end][1][0], profit[end][2][0])
