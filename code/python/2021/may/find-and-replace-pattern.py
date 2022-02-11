class Solution:
    def findAndReplacePattern(self, words, p):
        def match(w):
            m1, m2 = {}, {}
            return all(
                (m1.setdefault(i, j), m2.setdefault(j, i)) == (j, i)
                for i, j in zip(w, p)
            )

        return filter(match, words)