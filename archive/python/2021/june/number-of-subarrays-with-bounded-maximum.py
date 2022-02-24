from typing import List


class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        res, dp = 0, 0
        prev = -1
        for i in range(len(nums)):
            # if nums[i] < left:
            # res += dp
            if nums[i] > right:
                dp = 0
                prev = i
            if left <= nums[i] <= right:
                dp = i - prev
            res += dp
        return res
