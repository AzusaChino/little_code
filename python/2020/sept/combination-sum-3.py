from functools import reduce
from itertools import combinations


class Solution:
    def combinations1(self, k, n):
        return [c for c in combinations(range(1, 10), k) if sum(c) == n]

    def combinations2(self, k, n):
        def combine(k, n, cap):
            if not k:
                return [[]] * (not n)
            return [combination + [last]
                    for last in range(1, cap)
                    for combination in combine(k - 1, n - last, last)]

        return combine(k, n, 10)

    def combination3(self, k, n):
        combs = [[]]
        for _ in range(k):
            combs = [[first] + comb
                     for comb in combs
                     for first in range(1, comb[0] if comb else 10)]
        return [c for c in combs if sum(c) == n]

    def combination4(self, k, n):
        return [c for c in
                reduce(lambda combs, _: [[first] + comb
                                         for comb in combs
                                         for first in range(1, comb[0] if comb else 10)],
                       range(k), [[]])
                if sum(c) == n]
