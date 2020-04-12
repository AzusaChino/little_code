#
# @lc app=leetcode id=518 lang=python3
#
# [518] Coin Change 2
#

# @lc code=start
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        combinations = [0] * (amount + 1)
        combinations[0] = 1
        for coin in coins:
            for i, _ in enumerate(combinations):
                if i + 1 > coin:
                    combinations[i] += combinations[i - coin]
        return combinations[amount]

# @lc code=end

