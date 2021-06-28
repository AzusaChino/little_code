from functools import reduce


class Solution:
    def removeDuplicates(self, S):
        return reduce(lambda s, c: s[:-1] if s[-1:] == c else s + c, S)

    def _removeDuplicates(self, S):
        res = []
        for c in S:
            if res and res[-1] == c:
                res.pop()
            else:
                res.append(c)
        return "".join(res)
