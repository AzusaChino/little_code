from typing import List


def _insert(nums: List[int], target: int) -> int:
    l = len(nums)
    for x in range(len(nums)):
        if target <= nums[x]:
            return x
    return l
