#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        x = 1 # records the unique value
        for i in range(len(nums)-1):
            if (nums[i] != nums[i+1]):
                nums[x] = nums[i+1]
                x += 1
        return x
    def removeDuplicates1(self, nums: List[int]) -> int:
        res, helper = [], []
        for i in range(len(nums)):
            val = nums[i]
            if val in helper:
                pass
            else:
                helper.append(val)
                res.append(val)
        print('res : ' + str(res))
        print('helper : ' + str(helper))
        return len(res)
# @lc code=end

