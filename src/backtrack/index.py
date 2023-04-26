import collections
from typing import List


class Solution:
    """
    1. 元素无重不可复选，即 nums 中的元素都是唯一的，每个元素最多只能被使用一次
    2. 元素可重不可复选，即 nums 中的元素可以存在重复，每个元素最多只能被使用一次
    3. 元素无重可复选，即 nums 中的元素都是唯一的，每个元素可以被使用若干次。
    """

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
        allow to use element multiple times
        '''
        ret = []
        track = []

        def backtrack(t, s, track):
            if t < 0:
                return
            if t == 0:
                ret.append(track[:])
                return
            for i in range(s, len(candidates)):
                track.append(candidates[i])
                # allow multiple usage
                backtrack(t - candidates[i], i, track)
                track.pop()

        backtrack(target, 0, track)

        return ret

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
        dup not allowed
        '''
        ret = []
        track = []

        candidates.sort()

        def backtrack(t, s, track):
            if t < 0:
                return
            if t == 0:
                ret.append(track[:])
                return
            for i in range(s, len(candidates)):
                # skip same value
                if i > s and candidates[i] == candidates[i - 1]:
                    continue
                track.append(candidates[i])
                backtrack(t - candidates[i], i + 1, track)
                track.pop()

        backtrack(target, 0, track)
        return ret

    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        '''
        1~10 k_numbers -> n
        '''
        ret = []
        track = []

        def backtrack(t, k, s, track):
            if t < 0:
                return
            # sum equal, used all slots
            if t == 0 and k == 0:
                ret.append(track[:])
                return
            for i in range(s, 10):
                track.append(i)
                backtrack(t - i, k - 1, i + 1, track)
                track.pop()

        backtrack(n, k, 1, track)
        return ret

    def combinationSum4(self, nums, target):
        '''
        coin change problem
        '''
        nums.sort()
        dp = [0] * (target + 1)
        # base case
        dp[0] = 1
        for i in range(target + 1):
            for num in nums:
                if num > i:
                    break
                dp[i] += dp[i - num]
        return dp[target]

    def subsets(self, nums: List[int]) -> List[List[int]]:
        ret = []
        track = []

        def backtrack(s, track):
            ret.append(track[:])
            for i in range(s, len(nums)):
                track.append(nums[i])
                backtrack(i + 1, track)
                track.pop()

        backtrack(0, track)
        return ret

    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ret = []
        track = []

        def backtrack(s, track):
            ret.append(track[:])
            for i in range(s, len(nums)):
                if i > s and nums[i] == nums[i - 1]:
                    continue
                track.append(nums[i])
                backtrack(i + 1, track)
                track.pop()

        backtrack(0, track)
        return ret

    def permute(self, nums: List[int]) -> List[List[int]]:
        ret = []
        track = []
        used = [False for _ in range(len(nums))]

        def backtrack(track):
            if len(track) == len(nums):
                ret.append(track[:])
                return
            for (i, n) in enumerate(nums):
                if used[i]:
                    continue
                track.append(n)
                used[i] = True
                backtrack(track)
                used[i] = False
                track.pop()

        backtrack(track)
        return ret

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ret = []
        track = []
        used = [False for _ in range(len(nums))]

        def backtrack(track):
            if len(track) == len(nums):
                ret.append(track[:])
                return
            for (i, n) in enumerate(nums):
                if used[i]:
                    continue
                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                track.append(n)
                used[i] = True
                backtrack(track)
                used[i] = False
                track.pop()

        backtrack(track)
        return ret

    def combine(self, n: int, k: int) -> List[List[int]]:
        ret = []
        track = []

        def backtrack(s, k, track):
            if k < 0:
                return
            if k == 0:
                ret.append(track[:])
                return
            for i in range(s, n - k + 2):
                track.append(i)
                backtrack(i + 1, k - 1, track)
                track.pop()

        backtrack(1, k, track)
        return ret

    def wordSubsets(self, A: str, B: str) -> List[str]:
        count = collections.Counter()
        for b in B:
            count |= collections.Counter(b)
        return [a for a in A if not count - collections.Counter(a)]


if __name__ == "__main__":
    s = Solution()
    print(s.combinationSum([2, 3, 4, 7], 7))
    print(s.combinationSum2([2, 5, 2, 1, 2], 5))
    print(s.combinationSum3(3, 9))
    print(s.subsets([0]))
    print(s.subsetsWithDup([1, 2, 2]))
    print(s.permute([1, 2, 3]))
    print(s.permuteUnique([1, 1, 2]))
    print(s.combine(4, 2))

    # c = collections.Counter()
    # c |= collections.Counter("ab")
    # print(c)
    # print(c - collections.Counter("abcd"))
