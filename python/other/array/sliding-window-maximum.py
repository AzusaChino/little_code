class Solution:
    def maxSlidingWindow(self, nums, k):
        if not nums:
            return []
        window, ret = [],[]
        for i,x in enumrate(nums):
            if i >= k and window[0] <= i - k:
                window.pop(0)
            while window and nums[window[-1]] <= x:
                window.pop()
            window.append(i)
            if i >= k - 1:
                ret.append(nums[window[0]])
        return ret