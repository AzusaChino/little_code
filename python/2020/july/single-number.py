from typing import List


def single1(nums: List[int]) -> int:
    res = 0
    for n in nums:
        res ^= n
    return res


def single2(nums: List[int]) -> int:
    x, y, mask = 0, 0, 0
    for i in nums:
        y ^= x & i
        x ^= i
        mask = ~(x & y)
        y &= mask
        x &= mask
    return x


def single3(nums: List[int]) -> List[int]:
    diff = 0
    for n in nums:
        diff ^= n
    diff &= -diff
    ret = [0, 0]
    for n in nums:
        if (n & diff) == 0:
            ret[0] = n
        else:
            ret[1] = n
    return ret
