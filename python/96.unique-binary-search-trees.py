#
# @lc app=leetcode id=96 lang=python3
#
# [96] Unique Binary Search Trees
#
import math
# @lc code=start
class Solution:
    def numTrees(self, n:int) -> int:
        res = [0] * (n + 1)
        res[0] = 1
        for i in range(1, n+1):
            for j in range(i):
                res[i] += res[j] * res[i-1-j]
        return res[n]
    def numTrees1(self, n: int) -> int:
        return math.factorial(2*n)/ (math.factorial(n) * math.factorial(n+1))
# @lc code=end

