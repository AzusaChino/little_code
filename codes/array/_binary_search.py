import math
from typing import List


def binary_search(nums, t) -> int:
    nums.sort()
    l, r = 0, len(nums) - 1
    while l <= r:
        m = l + (r - l) // 2
        if nums[m] > t:
            r = m - 1
        elif nums[m] < t:
            l = m + 1
        else:
            return m
    return l


def binary_search_iter(nums, t):
    def helper(nums, t, l, r):
        if l > r:
            return -1
        m = l + (r - l) // 2
        if nums[m] > t:
            return helper(nums, t, l, m - 1)
        elif nums[m] < t:
            return helper(nums, t, m + 1, l)
        else:
            return m

    return helper(nums, t, 0, len(nums) - 1)


def _bisect_left(nums, t):
    nums.sort()
    l, r = 0, len(nums)
    while l <= r:
        m = (l + r) // 2
        if nums[m] < t:
            l = m + 1
        else:  # 无限向左偏移，直到右侧没有 = t 的数值
            r = m - 1
    return l


def _bisect_right(nums, t):
    nums.sort()
    l, r = 0, len(nums)
    while l <= r:
        m = (l + r) // 2
        if nums[m] > t:
            r = m - 1
        else:  # 无限向右偏移，直到左侧没有 = t 的数值
            l = m + 1
    return l


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        N = len(nums)
        if N == 1:
            return 0
        l, r = 0, N - 1
        while l < r:
            m = l + (r - l) // 2
            mr = m + 1
            if nums[m] < nums[mr]:
                l = mr
            else:
                r = m
        return l

    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def feasible(speed) -> bool:
            # return sum((pile - 1) // speed + 1 for pile in piles) <= h
            return sum(math.ceil(pile / speed) for pile in piles)

        l, r = 1, max(piles)
        while l < r:
            m = l + (r - l) // 2
            if feasible(m):
                r = m
            else:
                l = m + 1
        return l

    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def feasible(capacity) -> bool:
            used_days, total = 1, 0
            for w in weights:
                total += w
                # over weight
                if total > capacity:
                    total = w
                    used_days += 1
                    if used_days > days:
                        return False
            return True

        l, r = max(weights), sum(weights)
        while l < r:
            m = l + (r - l) // 2
            if feasible(m):
                r = m
            else:
                l = m + 1
        return l

    def splitArray(self, nums: List[int], k: int) -> int:
        """
        419
        """

        def feasible(capacity):
            total, used = 0, 1
            for n in nums:
                total += n
                if total > capacity:
                    total = n
                    used += 1
                    if used > k:
                        return False
            return True

        l, r = max(nums), sum(nums)
        while l < r:
            m = l + (r - l) // 2
            if feasible(m):
                r = m
            else:
                l = m + 1
        return l

    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        """
        1482
        """

        def feasible(wait) -> bool:
            f, b = 0, 0
            for d in bloomDay:
                if d > wait:
                    f = 0
                else:
                    b += (f + 1) // k
                    f = (f + 1) % k
            return b >= m

        if len(bloomDay) < m * k:
            return -1
        l, r = 1, max(bloomDay)
        while l < r:
            m = l + (r - l) // 2
            if feasible(m):
                r = m
            else:
                l = m + 1
        return l


if __name__ == "__main__":
    nums = [1, 3, 4, 5, 6, 7, 7, 7, 11, 18]
    print(binary_search(nums[:], 7))
    print(_bisect_left(nums[:], 8))
    print(_bisect_right(nums[:], 8))
