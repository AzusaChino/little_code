#
# @lc app=leetcode id=367 lang=python3
#
# [367] Valid Perfect Square
#

# @lc code=start
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        r = num
        while r*r > num:
            r = (r + num/r) /2
        return r == int(r)
# @lc code=end

