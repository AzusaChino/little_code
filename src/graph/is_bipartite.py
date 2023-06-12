from typing import List
from collections import deque


class Solution:
    # 记录图是否符合二分图性质
    ok = True
    # 记录图中节点的颜色，False 和 True 代表两种不同颜色
    color = []
    # 记录图中节点是否被访问过
    visited = []

    def isBipartite(self, graph: List[List[int]]) -> bool:
        N = len(graph)

        def dfs(start):
            if not self.ok:
                return
            self.visited[start] = True
            for nb in graph[start]:
                if not self.visited[nb]:
                    self.color[nb] = not self.color[start]
                    dfs(nb)
                else:
                    if self.color[nb] == self.color[start]:
                        self.ok = False
                        return

        for i in range(N):
            if not self.visited[i]:
                dfs(i)
        return self.ok


class Solution:
    # 记录图是否符合二分图性质
    ok = True
    # 记录图中节点的颜色，False 和 True 代表两种不同颜色
    color = []
    # 记录图中节点是否被访问过
    visited = []

    def isBipartite(self, graph: List[List[int]]) -> bool:
        N = len(graph)

        def bfs(start):
            q = deque()
            self.visited[start] = True
            q.append(start)

            while q and self.ok:
                cur = q.popleft()
                for nb in graph[cur]:
                    if not self.visited[nb]:
                        self.color[nb] = not self.color[cur]
                        self.visited[nb] = True
                        q.append(nb)
                    else:
                        if self.visited[nb] == self.visited[cur]:
                            self.ok = False
                            return

        for i in range(N):
            bfs(i)
        return self.ok
