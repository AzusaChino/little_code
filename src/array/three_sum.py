from typing import List


def two_sum(nums, t):
    d = {}
    for i, n in enumerate(nums):
        d[t - n] = i
    for i, n in enumerate(nums):
        if n in d and d[n] != i:
            return [i, d[n]]
    return [-1, -1]


class Solution:
    # sum to zero
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res, k = [], 0
        for k in range(len(nums) - 2):
            # skip non-negative
            if nums[k] > 0:
                break
            if k > 0 and nums[k] == nums[k - 1]:
                continue
            i, j = k + 1, len(nums) - 1
            while i < j:
                s = nums[k] + nums[i] + nums[j]
                if s < 0:
                    i += 1
                    while i < j and nums[i] == nums[i - 1]:
                        i += 1
                elif s > 0:
                    j -= 1
                    while i < j and nums[j] == nums[j + 1]:
                        j -= 1
                else:
                    res.append([nums[k], nums[i], nums[j]])
                    i += 1
                    j -= 1
                    while i < j and nums[i] == nums[i - 1]:
                        i += 1
                    while i < j and nums[j] == nums[j + 1]:
                        j -= 1
        return res


if __name__ == "__main__":
    nums = [2, 5, 1, 4]
    print(two_sum(nums, 5))
