class Solution:
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        c = 0
        n = len(nums)
        nums.sort()
        for i in range(n-1,1,-1):
            lo = 0
            hi = i - 1
            while lo < hi:
                if nums[hi]+nums[lo] > nums[i]:
                    c += hi-lo
                    hi -= 1
                else:
                    lo += 1
        return c
