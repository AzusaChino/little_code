#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#
# double pointer
# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # O(n^2)
        m = 0
        for i in range(len(height)-1):
            for j in range(i+1, len(height)):
                area = (j-1) * min(height[i], height[j])
                m = max(m, area)
        return m
    
    def maxArea2(self, height: List[int]) -> int:
        L,R,width, res =0, len(height)-1, len(height)-1,0
        for w in range(width, 0, -1):
            if height[L] < height[R]:
                res , L = max(res, height[L] * w), L +1
            else:
                res, R = max(res, height[R] * w), R - 1
        return res

# @lc code=end
