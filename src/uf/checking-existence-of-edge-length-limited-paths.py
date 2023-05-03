from typing import List


class UF:
    def __init__(self, n) -> None:
        self.n = n
        self.parent = list(range(n))
        self.rank = [1] * n

    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def union(self, p, q):
        rootP, rootQ = self.find(p), self.find(q)
        if rootP == rootQ:
            return
        if self.rank[rootP] > self.rank[rootQ]:
            self.parent[rootQ] = self.parent[rootP]
            self.rank[rootP] += self.rank[rootQ]
        else:
            self.parent[rootP] = self.parent[rootQ]
            self.rank[rootQ] += self.rank[rootP]

    def connected(self, p, q):
        return self.find(p) == self.find(q)


class Solution:
    def distanceLimitedPathsExist(
        self, n: int, edgeList: List[List[int]], queries: List[List[int]]
    ) -> List[bool]:
        """
        Sort queries based on weight and sort edges based on weight as well.
        Scan through queries from lowest to highest weight and connect the edges whose weight strictly fall below this limit.
        Check if the queried nodes p and q are connected in Union-Find structure.
        If so, put True in the relevant position; otherwise put False.
        """
        queries = sorted((w, p, q, i) for i, (p, q, w) in enumerate(queries))
        edgeList = sorted((w, u, v) for u, v, w in edgeList)

        uf = UF(n)
        ret = [None] * len(queries)
        e_i = 0
        for w, p, q, i in queries:
            while e_i < len(edgeList) and edgeList[e_i][0] < w:
                _, u, v = edgeList[e_i]
                uf.union(u, v)
                e_i += 1
            ret[i] = uf.connected(p, q)
        return ret
