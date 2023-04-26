def sorted_square(nums):
    n = len(nums)
    ret = [0 for _ in range(n)]
    l, r, k = 0, n - 1, n - 1
    while l <= r:
        lr = nums[l] ** 2
        rr = nums[r] ** 2
        if lr < rr:
            ret[k] = rr
            r -= 1
        else:
            ret[k] = lr
            l += 1
        k -= 1
    return ret


if __name__ == "__main__":
    print(sorted_square([-4, -1, 0, 3, 10]))
