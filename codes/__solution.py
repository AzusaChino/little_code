import collections
import heapq
import sys
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        N = len(rooms)
        visited = set([0])
        q = []
        for n in rooms[0]:
            q.append(n)
        while q:
            sz = len(q)
            for _ in range(sz):
                n = q.pop()
                if n not in visited:
                    visited.add(n)
                    for nn in rooms[n]:
                        if nn not in visited:
                            q.append(nn)
        return len(visited) == N

    def longestOnes(self, nums: List[int], k: int) -> int:
        N = len(nums)
        i = 0
        for j in range(N):
            k -= 1 - nums[j]
            if k < 0:
                k += 1 - nums[i]
                i += 1
            # print((k, i))
        return j - i + 1

    def numberOfSubarrays(self, nums: List[int], k: int) -> int:

        N = len(nums)

        def at_most(k):
            ret = i = j = 0
            while j < N:
                k -= nums[j] % 2
                while k < 0:
                    k += nums[i] % 2
                    i += 1
                ret += j - i + 1
                j += 1
            return ret

        return at_most(k) - at_most(k - 1)

    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        N = len(nums)

        def at_most(k):
            cnt = collections.Counter()
            ret = i = j = 0
            while j < N:
                if cnt[nums[j]] == 0:
                    k -= 1
                cnt[nums[j]] += 1
                while k < 0:
                    cnt[nums[i]] -= 1
                    if cnt[nums[i]] == 0:
                        k += 1
                    i += 1
                ret += j - i + 1
                j += 1
            return ret

        return at_most(k) - at_most(k - 1)

    def numberOfSubstrings(self, s: str) -> int:
        count = collections.Counter(s)
        N = ret = len(s)
        i = 0
        perc = N // 4
        for j, c in enumerate(s):
            count[c] -= 1
            while i < N and all(perc >= count[cc] for cc in "QWER"):
                ret = min(ret, j - i + 1)
                count[s[i]] += 1
                i += 1
        return ret

    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        roads = set()
        graph = collections.defaultdict(list)
        for u, v in connections:
            roads.add((u, v))
            graph[u].append(v)
            graph[v].append(u)

        def dfs(u, parent):
            ret = 0
            if (parent, u) in roads:
                ret += 1
            for v in graph[u]:
                if v != parent:
                    ret += dfs(v, u)
            return ret

        return dfs(0, -1)

    def characterReplacement(self, s: str, k: int) -> int:
        N = len(s)
        curMax = ret = 0
        l = r = 0
        cnt = collections.Counter()
        while r < N:
            cnt[s[r]] += 1
            curMax = max(curMax, cnt[s[r]])
            if r - l + 1 - curMax > k:
                cnt[s[l]] -= 1
                l += 1
            ret = max(ret, r - l + 1)
            r += 1
        return ret

    def minCost(self, nums: List[int]) -> int:
        """
        256
        """
        if not nums:
            return 0
        N = len(nums)
        for i in range(1, N):
            nums[i][0] += min(nums[i - 1][1], nums[i - 1][2])
            nums[i][1] += min(nums[i - 1][0], nums[i - 1][2])
            nums[i][2] += min(nums[i - 1][0], nums[i - 1][1])
        return min(nums[N - 1][0], nums[N - 1][1], nums[N - 1][2])

    def longestSubarray(self, nums: List[int]) -> int:
        N = len(nums)
        ret = 0
        l = r = 0
        zc = 0
        while r < N:
            if nums[r] == 0:
                zc += 1
            while zc > 1:
                if nums[l] == 0:
                    zc -= 1
                l += 1
            ret = max(ret, r - l)
            r += 1
        return ret

    def goodNodes(self, root: TreeNode) -> int:
        self.ret = 0

        def dfs(node: TreeNode, path: List[int]):
            if not node:
                return
            if not path or all(map(lambda x: node.val >= x, path)):
                self.ret += 1
            path.append(node.val)
            if node.left:
                dfs(node.left, path)
            if node.right:
                dfs(node.right, path)
            path.pop()

        dfs(root, [])

        return self.ret

    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return root
        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        else:
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                min_node = root.right
                while min_node.left:
                    min_node = min_node.left
                root.val = min_node.val
                root.right = self.deleteNode(root.right, root.val)
        return root

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ret = []
        if not root:
            return ret
        q = collections.deque()
        q.append(root)
        while q:
            sz = len(q)
            for i in range(sz):
                node = q.popleft()
                if i + 1 == sz:
                    ret.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return ret

    def lowestCommonAncestor(
        self, root: "TreeNode", p: "TreeNode", q: "TreeNode"
    ) -> "TreeNode":
        if not root:
            return root
        if root is p or root is q:
            return root
        l = self.lowestCommonAncestor(root.left, p, q)
        r = self.lowestCommonAncestor(root.right, p, q)
        if l and r:
            return root
        if not l and not r:
            return None
        return l and l or r

    def calcEquation(
        self, equations: List[List[str]], values: List[float], queries: List[List[str]]
    ) -> List[float]:
        self.graph, self.visited = collections.defaultdict(dict), set()
        for (l, r), v in zip(equations, values):
            self.graph[l][r] = v
            self.graph[r][l] = 1 / v
        ret = []

        def dfs(cur, value):
            if cur == self.goal:
                return value
            for adj, adv in self.graph[cur].items():
                if adj not in self.visited:
                    self.visited.add(adj)
                    r = dfs(adj, adv * value)
                    if r != -1:
                        return r
                    self.visited.remove(adj)
            return -1

        for start, self.goal in queries:
            if start not in self.graph:
                ret.append(-1)
            else:
                ret.append(dfs(start, 1))
                self.visited.clear()

        return ret

    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        lv, ret = -1, -sys.maxsize
        q = collections.deque()
        q.append(root)
        step = 1
        while q:
            sz = len(q)
            cur = 0
            for _ in range(sz):
                node = q.popleft()
                cur += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if cur > ret:
                lv = step
                ret = cur
            step += 1
        return lv

    def tribonacci(self, n: int) -> int:
        a, b, c = 1, 0, 0
        for _ in range(n):
            a, b, c = b, c, a + b + c
        return c

    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        M, N = len(grid), len(grid[0])
        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0]]

        rotten = collections.deque()
        fresh_cnt = 0

        for i in range(M):
            for j in range(N):
                if grid[i][j] == 2:
                    rotten.append((i, j))
                elif grid[i][j] == 1:
                    fresh_cnt += 1

        # 2. bfs rot
        steps = 0
        while rotten and fresh_cnt:
            steps += 1
            sz = len(rotten)
            for _ in range(sz):
                m, n = rotten.popleft()
                for i, j in dirs:
                    if 0 <= m + i < M and 0 <= n + j < N and grid[m + i][n + j] == 1:
                        fresh_cnt -= 1
                        grid[m + i][n + j] = 2
                        rotten.append((m + i, n + j))

        return fresh_cnt and -1 or steps

    def wallsAndGates(self, rooms: List[List[int]]):
        if not rooms:
            return

        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0]]
        M, N = len(rooms), len(rooms[0])
        INF = float("inf")
        q = collections.deque()

        for i in range(M):
            for j in range(N):
                if rooms[i][j] == 0:
                    q.append((i, j))

        while q:
            i, j = q.popleft()
            for x, y in dirs:
                xx, yy = i + x, j + y
                if xx < 0 or xx >= M or yy < 0 or yy >= N or rooms[xx][yy] != INF:
                    continue
                # preem
                rooms[xx][yy] = rooms[i][j] + 1
                q.append((xx, yy))

    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        M, N = len(maze), len(maze[0])
        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0]]

        is_exit = lambda i, j: i * j == 0 or i == M - 1 or j == N - 1

        q = collections.deque()
        x, y = entrance
        q.append((x, y, 0))
        maze[x][y] = "+"

        while q:
            i, j, v = q.popleft()
            for x, y in dirs:
                xi, yj = x + i, y + j
                if xi < 0 or xi >= M or yj < 0 or yj >= N or maze[xi][yj] == "+":
                    continue
                maze[xi][yj] = "+"
                if is_exit(xi, yj):
                    return v + 1
                q.append((xi, yj, v + 1))

        return -1

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.target = targetSum

        def helper(node, prev_sum):
            if not node:
                return 0
            cur_sum = prev_sum + node.val
            ok = cur_sum == self.target and 1 or 0
            return ok + helper(node.left, cur_sum) + helper(node.right, cur_sum)

        if not root:
            return 0
        return (
            helper(root, 0)
            + self.pathSum(root.left, targetSum)
            + self.pathSum(root.right, targetSum)
        )

    def longestZigZag(self, root: TreeNode):
        def dfs(root):
            if not root:
                return [-1, -1, -1]
            left, right = dfs(root.left), dfs(root.right)
            return [
                left[1] + 1,
                right[0] + 1,
                max(left[1] + 1, right[0] + 1, left[2], right[2]),
            ]

        return dfs(root)[-1]

    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        M, N = len(text1), len(text2)
        dp = [[0] * (N + 1) for _ in range(M + 1)]

        for i in range(1, M + 1):
            for j in range(1, N + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])

        return dp[M][N]

    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        total = ret = 0
        pq = []
        arr = sorted(list(zip(nums1, nums2)), key=lambda x: -x[1])
        for a, b in arr:
            if len(pq) + 1 > k:
                total -= heapq.heappop(pq)
            heapq.heappush(pq, a)
            total += a
            if len(pq) == k:
                ret = max(ret, total * b)
        return ret

    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # N >= 2
        N = len(cost)
        dp = [0] * N

        # base case
        dp[0] = cost[0]
        dp[1] = cost[1]

        for i in range(2, N):
            dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])

        return min(dp[N - 1], dp[N - 2])


class TrieNode:
    def __init__(self, v):
        self.v = v
        self.children = [None] * 26
        self.is_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode("#")

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if node.children[ord(c) - ord("a")]:
                node = node.children[ord(c) - ord("a")]
            else:
                node.children[ord(c) - ord("a")] = TrieNode(c)
                node = node.children[ord(c) - ord("a")]
        node.is_word = True

    def search(self, word: str) -> bool:
        node = self.root
        for c in word:
            if node.children[ord(c) - ord("a")]:
                node = node.children[ord(c) - ord("a")]
            else:
                return False
        return node.is_word

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for c in prefix:
            if node.children[ord(c) - ord("a")]:
                node = node.children[ord(c) - ord("a")]
            else:
                return False
        return True

    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        x, y = [], []
        cnt, ret = 0, 0
        N = len(costs)
        l, r = 0, N - 1
        while cnt < k:
            while l <= r and len(x) < candidates:
                heapq.heappush(x, costs[l])
                l += 1
            while l <= r and len(y) < candidates:
                heapq.heappush(y, costs[r])
                r -= 1
            a = x and x[0] or sys.maxsize
            b = y and y[0] or sys.maxsize

            if a <= b:
                ret += a
                heapq.heappop(x)
            else:
                ret += b
                heapq.heappop(y)
            cnt += 1
        return ret


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.pq = []
        self.k = k
        for n in nums:
            self.helper(n)

    def add(self, val: int) -> int:
        self.helper(val)
        return self.pq[0]

    def helper(self, val):
        heapq.heappush(self.pq, val)
        if len(self.pq) > self.k:
            heapq.heappop(self.pq)


if __name__ == "__main__":
    s = Solution()
    # print(s.canVisitAllRooms([[1], [2], [3], []]))
    # print(s.longestOnes([0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1], 3))
    # print(s.numberOfSubarrays([2, 2, 2, 1, 2, 2, 1, 2, 2, 2], 2))
    # print(s.longestSubarray([1, 0]))
    # print(s.orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]))
    print(s.nearestExit([["+", "+", "+"], [".", ".", "."], ["+", "+", "+"]], [1, 0]))
