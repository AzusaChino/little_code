from typing import List


def largest_divisible_subset(nums: List[int]):
    S = {-1: set()}
    for x in sorted(nums):
        S[x] = max((S[d] for d in S if x % d == 0), key=len) | {x}
    return list(max(S.values(), key=len))
