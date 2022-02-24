import collections


class Solution(object):
    def combinationSum4(self, nums, target):
        nums, combs = sorted(nums), [1] + [0] * (target)
        for i in range(target + 1):
            for num in nums:
                if num > i:
                    break
                if num == i:
                    combs[i] += 1
                if num < i:
                    combs[i] += combs[i - num]
        return combs[target]


class Solution_Followup(object):
    def combinationSum4WithLength(
        self, nums, target, length, memo=collections.defaultdict(int)
    ):
        if length <= 0:
            return 0
        if length == 1:
            return 1 * (target in nums)
        if (target, length) not in memo:
            for num in nums:
                memo[target, length] += self.combinationSum4(
                    nums, target - num, length - 1
                )
        return memo[target, length]