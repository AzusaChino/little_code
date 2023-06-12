from typing import List


class UF:
    def __init__(self, n):
        self.n = n
        self.parent = list(range(n))
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, p, q):
        rootP, rootQ = self.find(p), self.find(q)
        if rootP == rootQ:
            return
        self.parent[rootQ] = rootP
        self.n -= 1
    
    def count(self):
        return self.n


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        N = len(isConnected)
        uf = UF(N)
        for i in range(N):
            for j in range(N):
                if isConnected[i][j]:
                    uf.union(i, j)
        return uf.count()
