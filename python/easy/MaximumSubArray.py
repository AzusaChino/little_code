def maximum(nums):
    m, s = 0, 0
    for x in range(1, len(nums)):
        m = max(m, nums[x] + m)
        s = max(s, m)
    return s


if __name__ == '__main__':
    print(maximum([1, 2, 3, 4]))
