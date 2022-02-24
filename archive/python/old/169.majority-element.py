#
# @lc app=leetcode id=169 lang=python3
#
# [169] Majority Element
#

# @lc code=start
class Solution:
    # NOTICE that the majority element always exist in the array,
    # so that the middle always is the answer
    def majorityElement(self, nums: List[int]) -> int:
        return sorted(nums)[len(nums)//2]
# @lc code=end

