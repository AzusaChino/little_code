#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start
class Solution:
    def mySqrt(self, x:int) -> int:
        r = x
        while r*r > x:
            r = (r + x//r)//2
        return r
    def mySqrt2(self, x: int) -> int:
        l, r = 0, x
        while l < r:
            mid = l + (r-l)/2
            if mid**2 > x:
                r = mid-1
            else:
                l = mid
        return int(r)
# @lc code=end

