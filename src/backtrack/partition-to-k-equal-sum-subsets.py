from typing import List


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        nums_sum = sum(nums)
        if nums_sum < k or nums_sum % k != 0:
            return False

        N = len(nums)
        subset_sum = nums_sum // k
        buckets = [0] * k
        nums.sort(reverse=True)

        def backtrack(j):
            if j == N:
                for i in range(k):
                    if buckets[i] != subset_sum:
                        return False
                return True
            for i in range(k):
                if buckets[i] + nums[j] <= subset_sum:
                    buckets[i] += nums[j]
                    if backtrack(j + 1):
                        return True
                    buckets[i] -= nums[j]
            return False

        return backtrack(0)
