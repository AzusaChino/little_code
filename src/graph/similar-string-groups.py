class UF:
    def __init__(self, n) -> None:
        self.d = [i for i in range(n)]

    def union(self, p, q):
        pf, qf = self.find(p), self.find(q)
        if pf == qf:
            return
        self.d[pf] = qf

    def find(self, x):
        if self.d[x] != x:
            self.d[x] = self.find(self.d[x])
        return self.d[x]


class Solution:
    def numSimilarGroups(self, strs):
        N = len(strs)
        uf = UF(N)
        for i in range(N):
            for j in range(i + 1, N):
                if sum(strs[i][k] != strs[j][k] for k in range(len(strs[i]))) in (0, 2):
                    uf.union(i, j)
        return len(set(uf.find(i) for i in range(N)))
