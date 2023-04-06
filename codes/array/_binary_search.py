from bisect import bisect_left


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


if __name__ == "__main__":
    nums = [1, 3, 4, 5, 6, 7, 7, 7, 11, 18]
    print(binary_search(nums[:], 7))
    print(_bisect_left(nums[:], 8))
    print(_bisect_right(nums[:], 8))
