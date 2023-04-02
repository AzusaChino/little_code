from bisect import bisect_left
from typing import List
from math import ceil


class Solution:
    def successfulPairs(
        self, spells: List[int], potions: List[int], success: int
    ) -> List[int]:
        ret = []
        potions.sort()
        pl = len(potions)
        for spell in spells:
            target = ceil(success / spell)
            index = binarySearch(potions, target)
            ret.append(pl - index)
        return ret


def binarySearch(arr: List[int], target: int) -> int:
    l, r = 0, len(arr) - 1
    while l <= r:
        m = l + (r - l) // 2
        if arr[m] < target:
            l = m + 1
        elif arr[m] > target:
            r = m - 1
        else:
            # find the most-left index
            while m - 1 >= 0 and arr[m] == arr[m - 1]:
                m -= 1
            return m
    return l


def successfulPairs(self, spells, potions, success):
    potions.sort()
    return [
        len(potions) - bisect_left(potions, ceil(success / spell)) for spell in spells
    ]


if __name__ == "__main__":
    spells = [5, 1, 3]
    potions = [1, 2, 3, 4, 5]
    s = Solution()
    print(s.successfulPairs(spells, potions, 7))
    # print(binarySearch(potions, 6))
