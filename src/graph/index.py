from typing import List, Optional
from collections import deque


class Node:
    def __init__(self, k, v) -> None:
        self.k = k
        self.v = v


class Graph:
    def __init__(self, n, neighbors: Optional[List[Node]]) -> None:
        self.n = n
        self.neighbors = neighbors


class Solution:
    visited = []
    onPath = []

    def traverse(self, graph: Graph):
        v = graph.n
        if self.visited[v]:
            return
        self.visited[v] = True
        self.onPath[v] = True
        for nb in graph.neighbors:
            self.traverse(nb)
        self.onPath[v] = False

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ret = []
        path = []

        def traverse(s: int, track: List[int]):
            track.append(s)
            if s == len(graph) - 1:
                ret.append(track[:])
            else:
                for v in graph[s]:
                    traverse(v, track)
            track.pop()

        traverse(0, path)
        return ret

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        注意图中并不是所有节点都相连，所以要用一个 for 循环将所有节点都作为起点调用一次 DFS 搜索算法。
        ref: https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/huan-jian--e36de/
        """

        def buildGraph():
            ret = [[] for _ in range(numCourses)]
            for edge in prerequisites:
                # 修完课程 from 才能修课程 to
                ret[edge[1]].append(edge[0])
            return ret

        self.hasCycle = False
        self.graph = buildGraph()

        def traverse(visited, path, step):
            # path track the current stack
            if path[step]:
                self.hasCycle = True
            if visited[step] or self.hasCycle:
                return
            visited[step] = True
            path[step] = True
            for s in self.graph[step]:
                traverse(visited, path, s)
            path[step] = False

        # track cycle
        visited = [False for _ in range(numCourses)]
        # backtrack
        path = visited[:]
        for i in range(numCourses):
            traverse(visited, path, i)
        return not self.hasCycle

    def can_finish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        所谓「出度」和「入度」是「有向图」中的概念，很直观：
        如果一个节点 x 有 a 条边指向别的节点, 同时被 b 条边所指, 则称节点 x 的出度为 a, 入度为 b。
        """

        def buildGraph():
            ret = [[] for _ in range(numCourses)]
            for edge in prerequisites:
                # 修完课程 from 才能修课程 to
                ret[edge[1]].append(edge[0])
            return ret

        self.hasCycle = False
        self.graph = buildGraph()

        self.indegree = [0 for _ in range(numCourses)]
        for p in prerequisites:
            self.indegree[p[0]] += 1
        q = deque()
        for i in range(numCourses):
            # 节点 i 没有入度，即没有依赖的节点
            # 可以作为拓扑排序的起点，加入队列
            if self.indegree[i] == 0:
                q.append(i)

        cnt = 0
        while q:
            cur = q.popleft()
            cnt += 1
            for nxt in self.graph[cur]:
                self.indegree[nxt] -= 1
                # 如果入度变为 0，说明 next 依赖的节点都已被遍历
                if self.indegree[nxt] == 0:
                    q.append(nxt)
        return cnt == numCourses

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:

        self.ret = [[] for _ in range(numCourses)]
        self.dd = [0 for _ in range(numCourses)]
        for pp in prerequisites:
            self.ret[pp[1]].append(pp[0])
            self.dd[pp[0]] += 1

        q = deque()
        for i in range(numCourses):
            if self.dd[i] == 0:
                q.append(i)

        ret = []
        while q:
            cur = q.popleft()
            ret.append(cur)
            for nxt in self.ret[cur]:
                self.dd[nxt] -= 1
                if self.dd[nxt] == 0:
                    q.append(nxt)
        if len(ret) != numCourses:
            return []
        return ret


if __name__ == "__main__":
    s = Solution()
    l = [[0, 10], [3, 18], [5, 5], [6, 11], [11, 14], [13, 1], [15, 1], [17, 4]]
    print(s.canFinish(20, l))
    print(s.can_finish(20, l))
