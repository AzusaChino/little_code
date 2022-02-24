#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#

# @lc code=start
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums: return 0
        if len(nums) == 1: return nums[0]
        dp = [0 for _ in range(len(nums)+1)]
        dp[1] = nums[0]
        for i in range(1, len(nums)):
            dp[i+1] = max(dp[i], dp[i-1]+ nums[i])
        return dp[len(nums)]
    
    def rob2(self, nums: List[int]) -> int:
        max_3_before, max_2_before, adajcent = 0, 0, 0
        for n in nums:
            max_3_before, max_2_before, adajcent = \
                max_2_before, adajcent, max(max_3_before + n, max_2_before+n)
        return max(max_2_before, adajcent)

# @lc code=end

