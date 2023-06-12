import collections
from typing import List


class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        N = len(bombs)
        ans = 0
        graph = collections.defaultdict(list)

        for i in range(N):
            for j in range(N):
                if i == j:
                    continue
                # if denotable, add to 邻接表
                if (
                    bombs[i][2] ** 2
                    >= (bombs[i][0] - bombs[j][0]) ** 2
                    + (bombs[i][1] - bombs[j][1]) ** 2
                ):
                    graph[i].append(j)

        def dfs(node, visited):
            for child in graph[node]:
                if child not in visited:
                    visited.add(child)
                    dfs(child, visited)

        for i in range(N):
            visited = set([i])
            dfs(i, visited)
            ans = max(ans, len(visited))

        return ans
