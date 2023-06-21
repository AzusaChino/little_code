from typing import List


class Solution:
    def getAverage(self, nums: List[int], k: int) -> List[int]:
        N = len(nums)
        ret = [-1] * N

        l, sm, d = 0, 0, 2*k+1
        for r in range(N):
            sm += nums[r]
            if (r-k+1) >= d:
                ret[l+k] = sm // d
                sm -= nums[l]
                l += 1

        return ret


class Solution_:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        prefix = [0]
        for x in nums:
            prefix.append(prefix[-1] + x)

        ans = [-1]*len(nums)
        for i, x in enumerate(nums):
            if k <= i < len(nums)-k:
                ans[i] = (prefix[i+k+1] - prefix[i-k])//(2*k+1)
        return ans
