#
# @lc app=leetcode id=50 lang=python3
#
# [50] Pow(x, n)
#
# 2**10 -> 2**5 -> 2*2**2 -> 2*2**1
# @lc code=start
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if not n:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        if n % 2:
            return x * self.myPow(x, n-1)
        return self.myPow(x*x , n / 2)
        
# @lc code=end

