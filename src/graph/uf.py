class UF:
    def __init__(self, n) -> None:
        self.parent = [i for i in range(n)]
        self.n = n

    def union(self, p, q):
        pp = self.find(p)
        pq = self.find(q)
        if pp == pq:
            return
        self.parent[pp] = pq
        self.count -= 1

    def connected(self, p, q) -> bool:
        pp = self.find(p)
        pq = self.find(q)
        return pp == pq

    def count(self) -> int:
        return self.count

    def find(self, x) -> int:
        while self.parent[x] != x:
            x = self.parent[x]
        return x

    def find_v2(self, x) -> int:
        """
        递归调用，每次会缩短查询时间
        """
        if self.parent[x] != x:
            self.parent[x] = self.find_v2(self.parent[x])
        return self.parent[x]


class UF_v2:
    def __init__(self, n):
        self.count = n
        self.parent = list(range(n))
        self.rank = [1] * n

    def find(self, p: int) -> int:
        # 路径压缩
        while p != self.parent[p]:
            self.parent[p] = self.parent[self.parent[p]]
            p = self.parent[p]
        return p

    def union(self, p: int, q: int) -> None:
        rootP, rootQ = self.find(p), self.find(q)
        if rootP == rootQ:
            return
        # ensure 
        if self.rank[rootP] < self.rank[rootQ]:
            self.parent[rootP] = rootQ
            self.rank[rootQ] += self.rank[rootP]
        else:
            self.parent[rootQ] = rootP
            self.rank[rootP] += self.rank[rootQ]
        self.count -= 1
