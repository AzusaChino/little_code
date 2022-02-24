from typing import Collection


class Solution:
    def canReorderDoubled(self, A):
        c = Collection.Counter(A)
        for x in sorted(c, key=abs):
            if c[x] > c[2 * x]:
                return False
            c[2 * x] -= c[x]
        return True
