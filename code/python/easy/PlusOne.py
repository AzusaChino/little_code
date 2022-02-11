def plus(nums):
    n = len(nums)
    for x in range(n - 1, 0, -1):
        if nums[x] < 9:
            nums[x] += 1
            return nums
        nums[x] = 0
    ns = [0 for _ in range(0, n + 1)]
    ns[0] = 1
    return ns


if __name__ == '__main__':
    print(plus([3, 4, 9]))
