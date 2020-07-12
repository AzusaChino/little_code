#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#
# 是否能暴力解法, 基本情况?
# 找最近 重复子问题
# 1. n=1 : 1
# 2. n=2 : 2
# 3. n=3 : f(1) + f(2)
# 4. n=4 : f(2) + f(3)
# n. n=n : f(n-1) + f(n-2) -> Fibonacci
# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if (n <= 2): return n
        f1, f2, f3 = 1, 2, 3
        for _ in range(3, n+1):
            f3 = f1 + f2
            f1 = f2
            f2 = f3
        return f3
    
    def climb_stairs(self, n: int, steps):
        self._dfs(n, [], steps)
    def _dfs(self, n, res, steps):
        if n == 0:
            print(res)
            return
        for step in steps:
            if n >= step:
                self._dfs(n-step, res+[step], steps)

