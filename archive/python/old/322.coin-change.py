#
# @lc app=leetcode id=322 lang=python3
#
# [322] Coin Change
#

# @lc code=start
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        value1 , value2 = [0], []
        nc = 0
        visited = [False] * (amount+1)
        visited[0] = True
        while value1:
            nc += value1
            for v in value1:
                for coin in coins:
                    newVal = v + coin
                    if newVal == amount:
                        return nc
                    elif newVal > amount:
                        continue
                    elif not visited[newVal]:
                        visited[newVal] = True
                        value2.append(newVal)
            value1, value2 = value2, []
        return -1

# @lc code=end

