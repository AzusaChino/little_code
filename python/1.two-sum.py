#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#
# a, b -> a+b == target
# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            if nums[i] not in map:
                map[target - nums[i]] = i+1
            else:
                return map[nums[i]], i+1
        return -1, -1
# @lc code=end

