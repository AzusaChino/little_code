from typing import List, Counter
import operator
from functools import reduce
import collections


class Solution:
    def wordSubsets(self, A: List[str], B: List[str]) -> List[str]:
        c_b = reduce(operator.or_, (Counter(w) for w in B))
        return [a for a in A if c_b & Counter(a) == c_b]

    def wordSubsets_(self, A, B):
        count = collections.Counter()
        for b in B:
            count |= collections.Counter(b)
        return [a for a in A if not count - Counter(a)]