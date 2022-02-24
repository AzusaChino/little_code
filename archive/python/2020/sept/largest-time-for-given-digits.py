import itertools
from typing import List


class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:
        return max(["%d%d:%d%d" % t for t in itertools.permutations(A) if t[:2] < (2, 4) and t[2] < 6] or [""])

    def __largestTimeFromDigits(self, A: List[int]) -> str:
        for p in itertools.permutations(sorted(A, reverse=True)):
            if p[0] * 10 + p[1] < 24 and p[2] < 6:
                return f"{p[0]}{p[1]}:{p[2]}{p[3]}"
        return ''
