from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        N = len(nums)
        for i in range(N):
            while nums[i] and nums[i] <= N and nums[nums[i] - 1] != nums[i]:
                nums[i], nums[nums[i] - 1] = nums[nums[i] - 1], nums[i]

        for i in range(N):
            if nums[i] != i + 1:
                return i + 1
        return N + 1


