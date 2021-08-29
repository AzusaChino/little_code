from typing import List


class Solutiin:
    def minPatches(self, nums: List[int], n: int) -> int:
        cnt = 0
        patch = 0
        tot = len(nums)
        i = 0
        while patch < n:
            if i < tot and patch + 1 >= nums[i]:
                patch += nums[i]
                i += 1
            else:
                cnt += 1
                # print(patch+1)
                patch += patch + 1  # patch + 1 is the new patch to be added
        return cnt
