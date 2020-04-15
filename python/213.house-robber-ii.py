#
# @lc app=leetcode id=213 lang=python3
#
# [213] House Robber II
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        return max(self.helper(nums, 0, len(nums)-2), self.helper(nums, 1, len(nums)-1))
    def helper(self, nums: List[int], start: int, end: int) -> int:
        pre, cur = 0, 0
        for i in range(start, end):
            temp = max(pre + nums[i], cur)
            pre = cur
            cur = temp
        return cur
# @lc code=end

