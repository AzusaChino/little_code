#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#
# a + b = -c (multi targets)
# 1. 暴力求解 O(n^3)
# 2. Hash表记录
# 3. 双指针 左右下标
# @lc code=start
class Solution:
    def threeSum2(self, nums: List[int]) -> List[List[int]]:
        if nums is None: return None
        nums.sort()
        res = []
        for i in range(len(nums)- 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i + 1, len(nums)-1 # two pointer
            while l < r:
                s = nums[i] + nums[l] + nums[r] # three sum
                if s < 0:
                    l +=1
                elif s > 0:
                    r -= 1
                else:
                    res.append([nums[i],nums[l],nums[r]])
                    while l < r and nums[l] == nums[l+1]: # clear same value
                        l += 1
                    while l < r and nums[r] == nums[r-1]: # clear same value
                        r -= 1
                    l += 1; r -= 1
        return res

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res, k = [], 0
        for k in range(len(nums) - 2):
            if nums[k] > 0: break
            if k > 0 and nums[k] == nums[k-1]: continue
            i,j = k+1, len(nums)-1
            while i<j:
                s = nums[k] + nums[i]+ nums[j]
                if s < 0:
                    i +=1
                    while i < j and nums[i] == nums[i-1]: i+=1
                elif s > 0:
                    j -= 1
                    while i < j and nums[j] == nums[j+1]: j-=1
                else:
                    res.append([nums[k], nums[i], nums[j]])
                    i += 1
                    j -= 1
                    while i < j and nums[i] == nums[i-1]: i+=1
                    while i < j and nums[j] == nums[j+1]: j-=1
        return res
# @lc code=end

