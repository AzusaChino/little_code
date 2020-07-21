import bisect


def searchRange1(nums, target):
    def search(lo, hi):
        if nums[lo] == target == nums[hi]:
            return [lo, hi]
        if nums[lo] <= target <= nums[hi]:
            mid = (lo + hi) / 2
            l, r = search(lo, mid), search(mid + 1, hi)
            return max(l, r) if -1 in l + r else [l[0], r[1]]
        return [-1, -1]

    return search(0, len(nums) - 1)


def searchRange2(nums, target):
    def search(n):
        lo, hi = 0, len(nums)
        while lo < hi:
            mid = (lo + hi) / 2
            if nums[mid] >= n:
                hi = mid
            else:
                lo = mid + 1
        return lo

    lo = search(target)
    return [lo, search(target + 1) - 1] if target in nums[lo:lo + 1] else [-1, -1]


def searchRange3(nums, target):
    lo = bisect.bisect_left(nums, target)
    return [lo, bisect.bisect(nums, target) - 1] if target in nums[lo:lo + 1] else [-1, -1]


if __name__ == '__main__':
    print(searchRange3([1, 2, 3, 4, 5, 5, 5, 6], 5))
