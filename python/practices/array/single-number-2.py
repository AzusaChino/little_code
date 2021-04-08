def single_number(nums):
    res = 0
    for i in range(32):
        s = 0
        for n in nums:
            if (n >> i & 1) == 1:
                s += 1

        s %= 3
        res |= s << i
    return res
