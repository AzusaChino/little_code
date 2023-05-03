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
            return 0
        if self.rank[rootP] > self.rank[rootQ]:
            self.parent[rootQ] = rootP
            self.rank[rootP] += self.rank[rootQ]
        else:
            self.parent[rootP] = rootQ
            self.rank[rootQ] += self.rank[rootP]
        return 1

    def getLargestComponentSize(self):
        sz = 0
        for i, v in enumerate(self.parent):
            if i == v and self.rank[i] > sz:
                sz = self.rank[i]
        return sz


class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        """
        Go through all edges of type 3 (Alice and Bob)
        If not necessary to add, increment res.
        Otherwith increment e1 and e2.

        Go through all edges of type 1 (Alice)
        If not necessary to add, increment res.
        Otherwith increment e1.

        Go through all edges of type 2 (Bob)
        If not necessary to add, increment res.
        Otherwith increment e2.

        If Alice's'graph is connected, e1 == n - 1 should valid.
        If Bob's graph is connected, e2 == n - 1 should valid.
        In this case we return res,
        otherwise return -1.
        """
        ret = e1 = e2 = 0
        uf = UF(n + 1)
        for w, u, v in edges:
            if w == 3:
                if uf.union(u, v):
                    e1 += 1
                    e2 += 1
                else:
                    ret += 1
        clone = uf.parent[:]
        for w, u, v in edges:
            if w == 1:
                if uf.union(u, v):
                    e1 += 1
                else:
                    ret += 1
        uf.parent = clone
        for w, u, v in edges:
            if w == 2:
                if uf.union(u, v):
                    e2 += 1
                else:
                    ret += 1
        return ret if e1 == e2 == n - 1 else -1
