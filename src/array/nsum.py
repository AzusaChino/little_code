import sys
from typing import List

# support
def two_sum(nums: List[int], target: int) -> List[int]:
    l, r = 0, len(nums) - 1
    while l <= r:
        m = l + (r - l) // 2
        if nums[m] == target:
            return [l, r]
        elif nums[m] < target:
            l += 1
        else:
            r -= 1
    return [-1, -1]


def two_sum_all(nums: List[int], target: int) -> List[List[int]]:
    ret = []
    nums.sort()
    l, r = 0, len(nums) - 1
    while l < r:
        lr, rr = nums[l], nums[r]
        m = lr + rr
        if m == target:
            ret.append([lr, rr])
            while l < r and nums[l] == lr:
                l += 1
            while l < r and nums[r] == rr:
                r -= 1
        elif m < target:
            while l < r and nums[l] == lr:
                l += 1
        else:
            while l < r and nums[r] == rr:
                r -= 1
    return ret


def n_sum_target(nums: List[int], n: int, start: int, target: int) -> List[List[int]]:
    # preassume sorted nums
    ret = []
    sz = len(nums)
    if n < 2 or sz < n:
        return ret
    if n == 2:
        l, r = start, sz - 1
        while l < r:
            lr, rr = nums[l], nums[r]
            t = lr + rr
            if t == target:
                ret.append([lr, rr])
                while l < r and nums[l] == lr:
                    l += 1
                while l < r and nums[r] == rr:
                    r -= 1
            elif t < target:
                while l < r and nums[l] == lr:
                    l += 1
            else:
                while l < r and nums[r] == rr:
                    r -= 1
    else:
        for i in range(start, sz):
            r = n_sum_target(nums, n - 1, i + 1, target - nums[i])
            for v in r:
                v.append(nums[i])
                ret.append(v)
            while i < sz - 1 and nums[i] == nums[i + 1]:
                i += 1
    return ret


def three_sum(nums: List[int], target: int) -> List[List[int]]:
    nums.sort()
    return n_sum_target(nums, 3, 0, target)


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ret = []
        for i in range(n - 1):
            if nums[i] > 0:
                break
            t = -nums[i]
            l, r = i + 1, n - 1
            while l < r:
                lr, rr = nums[l], nums[r]
                if t == lr + rr:
                    ret.append([nums[i], nums[l], nums[r]])
                    break
                elif t > lr + rr:
                    l += 1
                else:
                    r -= 1
        return ret

    def threeSumClosest(self, nums: List[int], target: int) -> int:
        if len(nums) < 3:
            return 0

        def two_sum_closest(nums, s, t):
            l, r = s, len(nums) - 1
            delta = sys.maxsize
            while l < r:
                sm = nums[l] + nums[r]
                if abs(delta) > abs(t - sm):
                    delta = t - sm
                if sm < t:
                    l += 1
                else:
                    r -= 1
            return t - delta

        nums.sort()
        ret = sys.maxsize
        for i in range(len(nums) - 2):
            sm = nums[i] + two_sum_closest(nums, i + 1, target - nums[i])
            if abs(ret) > abs(target - sm):
                ret = target - sm

        return target - ret


if __name__ == "__main__":
    print(two_sum_all([1, 3, 2, 3, 4], 5))
    print(three_sum([1, 3, 2, 4, 3], 7))
    s = Solution()
    print(s.threeSum([-1, 0, 1, 2, -1, -4]))
