def single_numbers(nums):
    diff = 0
    for n in nums:
        diff ^= n

    diff &= -diff

    rets = [0, 0]
    for n in nums:
        if (n & diff) == 0:
            rets[0] ^= n
        else:
            rets[1] ^= n

    return rets
