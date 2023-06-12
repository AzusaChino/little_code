import heapq
from math import log
from typing import List, Optional
from collections import Counter, defaultdict, deque


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class FrequencyTracker:
    def __init__(self):
        self.d = {}
        self.f = {}

    def add(self, number: int) -> None:
        if number in self.d.keys():
            f = self.d[number]
            self.d[number] += 1
            self.f[f].remove(number)
            if f + 1 in self.f.keys():
                self.f[f + 1].add(number)
            else:
                self.f[f + 1] = set([number])

        else:
            self.d[number] = 1
            if 1 in self.f.keys():
                self.f[1].add(number)
            else:
                self.f[1] = set([number])

    def deleteOne(self, number: int) -> None:
        if number in self.d.keys():
            f = self.d[number]
            if f <= 1:
                del self.d[number]
            else:
                self.d[number] -= 1
            self.f[f].remove(number)
            if f <= 1:
                return
            if f - 1 in self.f.keys():
                self.f[f - 1].add(number)
            else:
                self.f[f - 1] = set([number])

    def hasFrequency(self, frequency: int) -> bool:
        return frequency in self.f.keys() and self.f[frequency]


class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        N = len(mat)
        ret = 0
        for i in range(N):
            ret += mat[i][i]
            ret += mat[i][N - 1 - i]
        if N % 2 != 0:
            ret -= mat[N // 2][N // 2]
        return ret

    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        m = len(matrix)
        n = len(matrix[0])
        upper_bound = 0
        lower_bound = m - 1
        left_bound = 0
        right_bound = n - 1
        res = []
        while len(res) < m * n:
            if upper_bound <= lower_bound:
                # 在顶部从左向右遍历
                for j in range(left_bound, right_bound + 1):
                    res.append(matrix[upper_bound][j])
                # 上边界下移
                upper_bound += 1

            if left_bound <= right_bound:
                # 在右侧从上向下遍历
                for i in range(upper_bound, lower_bound + 1):
                    res.append(matrix[i][right_bound])
                # 右边界左移
                right_bound -= 1

            if upper_bound <= lower_bound:
                # 在底部从右向左遍历
                for j in range(right_bound, left_bound - 1, -1):
                    res.append(matrix[lower_bound][j])
                # 下边界上移
                lower_bound -= 1

            if left_bound <= right_bound:
                # 在左侧从下向上遍历
                for i in range(lower_bound, upper_bound - 1, -1):
                    res.append(matrix[i][left_bound])
                # 左边界右移
                left_bound += 1

        return res

    def generateMatrix(self, n: int) -> List[List[int]]:
        grid = [[0] * n for _ in range(n)]
        ub, bb, lb, rb = 0, n - 1, 0, n - 1
        num = 1
        target = n**2
        while num <= target:
            if ub <= bb:
                for i in range(lb, rb + 1):
                    grid[ub][i] = num
                    num += 1
                ub += 1
            if lb <= rb:
                for i in range(ub, bb + 1):
                    grid[i][rb] = num
                    num += 1
                rb -= 1
            if ub <= bb:
                for i in range(rb, lb - 1, -1):
                    grid[bb][i] = num
                    num += 1
                bb -= 1
            if lb <= rb:
                for i in range(bb, ub - 1, -1):
                    grid[i][lb] = num
                    num += 1
                lb += 1
        return grid

    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        M, N = len(nums1), len(nums2)
        dp = [[0] * (N + 1) for _ in range(M + 1)]

        for i in range(1, M + 1):
            for j in range(1, N + 1):
                if nums1[i - 1] == nums2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        return dp[M][N]

    def addMinimum(self, word: str) -> int:
        N = len(word)
        k, prev = 0, "z"
        for c in word:
            k += c <= prev
            prev = c
        return k * 3 - N

    def matrixSum(self, nums: List[List[int]]) -> int:
        if not nums:
            return 0
        ret = 0
        M, N = len(nums), len(nums[0])
        for j in range(N):
            tmp = -1
            for i in range(M):
                tmp = max(tmp, nums[i][j])
            print(tmp)
            ret += tmp
        return ret

    def maxMoves(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        M, N = len(grid), len(grid[0])

        def helper(i, j):
            steps = 0
            q = deque()
            visited = set()
            visited.add((i, j))
            q.append((i, j))
            while q:
                sz = len(q)
                for _ in range(sz):
                    m, n = q.popleft()
                    if (
                        m - 1 >= 0
                        and n + 1 < N
                        and grid[m][n] < grid[m - 1][n + 1]
                        and (m - 1, n + 1) not in visited
                    ):
                        q.append((m - 1, n + 1))
                        visited.add((m - 1, n + 1))
                    if (
                        n + 1 < N
                        and grid[m][n] < grid[m][n + 1]
                        and (m, n + 1) not in visited
                    ):
                        q.append((m, n + 1))
                        visited.add((m, n + 1))
                    if (
                        m + 1 < M
                        and n + 1 < N
                        and grid[m][n] < grid[m + 1][n + 1]
                        and (m + 1, n + 1) not in visited
                    ):
                        q.append((m + 1, n + 1))
                        visited.add((m + 1, n + 1))
                steps += 1

            return steps - 1

        ret = 0
        for i in range(M):
            for j in range(N):
                ret = max(ret, helper(i, j))
        return ret

    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        uf = UF(n)
        counter = Counter()
        for (w, v) in edges:
            uf.union(w, v)
            counter[w] += 1
            counter[v] += 1

        groups = set(uf.find(i) for i in range(n))

        for i in range(n):
            if uf.sizeof(i) != counter[i] + 1:
                groups.discard(uf.find(i))

        return len(groups)

    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        N = len(A)
        ret = []
        ac, bc = set(), set()

        for i in range(N):
            ac.add(A[i])
            bc.add(B[i])
            cc = ac.intersection(bc)
            ret.append(len(cc))
        return ret

    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        ind = [0] * n
        for edge in edges:
            ind[edge[1]] += 1
        ret = []
        for (i, v) in enumerate(ind):
            if v == 0:
                ret.append(i)
        return ret

    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        prev = cnt = 0
        for n in flowerbed:
            if n:
                prev = 1
            else:
                if prev == 1:
                    prev = 0
                else:
                    prev = 1
                    cnt += 1

        return cnt >= n

    def reverseWords(self, s: str) -> str:
        def flip(s, l, r):
            while l < r:
                s[l], s[r] = s[r], s[l]

        flip(s, 0, len(s) - 1)
        i = j = 0
        while j < len(s):
            c = s[j]
            if c.isspace():
                flip(s, i, j - 1)
                i = j + 1
            j += 1
        flip(s, i, j - 1)
        return s

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        N = len(nums)
        ret = [0] * N
        prev = [1] * N
        suf = [1] * N
        for i in range(1, N):
            prev[i] = prev[i - 1] * nums[i - 1]

        for j in range(N - 2, -1, -1):
            suf[j] = suf[j + 1] * nums[j + 1]

        for i in range(N):
            ret[i] = prev[i] * suf[i]

        return ret

    def compress(self, chars: List[str]) -> int:
        N = len(chars)
        c = ""
        cnt = 0
        ret = 0
        for i in range(N):
            if chars[i] != c:
                if c != "":
                    if cnt > 1:
                        ret += 1 + len(str(cnt))
                    elif cnt == 1:
                        ret += 1
                c = chars[i]
                cnt = 1
            else:
                cnt += 1
        if cnt > 1:
            ret += 1 + len(str(cnt))
        elif cnt == 1:
            ret += 1
        return ret

    def isSubsequence(self, s: str, t: str) -> bool:
        ss = list(s)
        j = len(t) - 1
        while j >= 0 and ss:
            if t[j] == ss[-1]:
                ss.pop()
            j -= 1
        return not ss

    def calcEquation(
        self, equations: List[List[str]], values: List[float], queries: List[List[str]]
    ) -> List[float]:
        self.graph, self.visited = defaultdict(dict), set()
        for (l, r), v in zip(equations, values):
            self.graph[l][r] = v
            self.graph[r][l] = 1 / v

        ret = []

        def dfs(cur: str, value: float) -> float:
            if cur == self.goal:
                return value
            for adj, adj_value in self.graph[cur].items():
                if adj not in self.visited:
                    self.visited.add(adj)
                    ret = dfs(adj, value * adj_value)
                    if ret != -1:
                        return ret
                    self.visited.remove(adj)
            return -1

        for orig, self.goal in queries:
            if orig not in self.graph:
                ret.append(-1)
            else:
                ret.append(dfs(orig, 1))
                self.visited.clear()
        return ret

    def maxOperations(self, nums: List[int], k: int) -> int:
        d = defaultdict(int)
        for n in nums:
            d[n] += 1
        ret = 0
        for n in nums:
            d[n] -= 1
            if d[n] >= 0 and k - n in d and d[k - n] > 0:
                d[k - n] -= 1
                ret += 1
        return ret

    def findMaxAverage(self, nums: List[int], k: int) -> float:
        N = len(nums)
        l = r = 0
        mx = -10001
        cur = 0
        while r < N:
            cur += nums[r]
            r += 1

            if r - l == k:
                mx = max(mx, cur)
                cur -= nums[l]
                l += 1

        return mx / k

    def largestAltitude(self, gain: List[int]) -> int:
        N = len(gain)
        p = [0] * (N + 1)
        for i in range(1, N + 1):
            p[i] = p[i - 1] + gain[i - 1]
        # print(p)
        return max(p)

    def pivotIndex(self, nums):
        left, right = 0, sum(nums)
        for index, num in enumerate(nums):
            right -= num
            if left == right:
                return index
            left += num
        return -1

    def closeStrings(self, word1: str, word2: str) -> bool:
        d1, d2 = defaultdict(int), defaultdict(int)
        st1, st2 = set(word1), set(word2)
        for w in word1:
            d1[w] += 1
        for w in word2:
            d2[w] += 1
        c1, c2 = Counter(d1.values()), Counter(d2.values())
        return c1 == c2 and not st1.difference(st2)

    def equalPairs(self, grid: List[List[int]]) -> int:
        N = len(grid)
        d = defaultdict(int)
        for r in grid:
            s = ",".join(map(str, r))
            d[s] += 1

        ret = 0
        for j in range(N):
            key = ",".join([str(grid[i][j]) for i in range(N)])
            ret += d.get(key, 0)

        return ret

    def countBits(self, n: int) -> List[int]:
        ret = [0]
        for i in range(1, n + 1):
            bits_cnt = log(i, 2)
            cur_range = int(2**bits_cnt)
            ret.append(1 + ret[i - cur_range])
        return ret

    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for n in asteroids:
            while stack and stack[-1] >= 0 and n < 0:  # collision happens
                collision = stack[-1] + n  # collision result
                if collision <= 0:
                    stack.pop()  # stack top is destroyed
                if collision >= 0:
                    break  # new astroid is destroyed or both are destroyed
            else:
                stack.append(n)
        return stack

    def decodeString(self, s: str) -> str:
        st = []
        n = 0
        ss = ""
        for c in s:
            if c == "[":
                st.append(ss)
                st.append(n)
                ss = ""
                n = 0
            elif c == "]":
                num, prev_s = st.pop(), st.pop()
                ss = prev_s + num * ss
            elif c.isdigit():
                n = n * 10 + int(c)
            else:
                ss += c
        return ss

    def shortestBridge(self, grid: List[List[int]]) -> int:
        bound = set()
        dire = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        m, n = len(grid), len(grid[0])
        # get root of island
        def getfirst():
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1:
                        return i, j

        # get boundary of island
        def dfs(i, j):
            grid[i][j] = -1
            for d in dire:
                x, y = i + d[0], j + d[1]
                if 0 <= x < m and 0 <= y < n:
                    if grid[x][y] == 0:
                        bound.add((i, j))
                    elif grid[x][y] == 1:
                        dfs(x, y)

        i, j = getfirst()
        dfs(i, j)
        # BFS to find next island
        step = 0
        while bound:
            new = []
            for i, j in bound:
                for d in dire:
                    x, y = i + d[0], j + d[1]
                    if 0 <= x < m and 0 <= y < n:
                        if grid[x][y] == 1:
                            return step
                        elif grid[x][y] == 0:
                            grid[x][y] = -1
                            new.append((x, y))
            step += 1
            bound = new

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = defaultdict(int)
        for i in nums:
            d[i] += 1
        pq = []
        for i, v in d.items():
            heapq.heappush(pq, (v, i))
            if len(pq) > k:
                heapq.heappop(pq)
        ret = [-1] * k
        for i in range(k - 1, -1, -1):
            ret[i] = heapq.heappop(pq)[1]
        return ret

    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        odd = head
        even = head.next
        even_head = even
        while even and even.next:
            odd.next = odd.next.next
            even.next = even.next.next
            odd = odd.next
            even = even.next
        odd.next = even_head
        return head

    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        if k == 0 or n >= k + maxPts:
            return 1
        dp = [1.0] + [0.0] * n
        w_sum = 1.0
        for i in range(1, n + 1):
            dp[i] = w_sum / maxPts
            if i < k:
                w_sum += dp[i]
            if i - maxPts >= 0:
                w_sum -= dp[i - maxPts]
        return sum(dp[k:])

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        while n:
            if m > 0 and nums1[m - 1] >= nums2[n - 1]:
                nums1[m + n - 1] = nums1[m - 1]
                m -= 1
            else:
                nums1[m + n - 1] = nums2[n - 1]
                n -= 1

    def kSmallestPairs(
        self, nums1: List[int], nums2: List[int], k: int
    ) -> List[List[int]]:
        queue = []

        def push(i, j):
            if i < len(nums1) and j < len(nums2):
                heapq.heappush(queue, [nums1[i] + nums2[j], i, j])

        push(0, 0)
        pairs = []
        while queue and len(pairs) < k:
            _, i, j = heapq.heappop(queue)
            pairs.append([nums1[i], nums2[j]])
            push(i, j + 1)
            if j == 0:
                push(i + 1, 0)
        return pairs


class UF:
    def __init__(self, n):
        self.n = n
        self.parent = list(range(n))
        self.rank = [1] * n
        self.count = [1] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, p, q):
        rootP, rootQ = self.find(p), self.find(q)
        if rootP == rootQ:
            return
        self.count[rootP] = self.count[rootQ] = self.count[rootP] + self.count[rootQ]
        if self.rank[rootP] >= self.rank[rootQ]:
            self.parent[rootQ] = rootP
            self.rank[rootP] += self.rank[rootQ]
        else:
            self.parent[rootP] = rootQ
            self.rank[rootQ] += self.rank[rootP]
        self.n -= 1

    def sizeof(self, x):
        return self.count[self.find(x)]


class StockSpanner:
    def __init__(self):
        self.stack = []

    def next(self, price):
        res = 1
        while self.stack and self.stack[-1][0] <= price:
            res += self.stack.pop()[1]
        self.stack.append([price, res])
        return res


class RecentCounter:
    def __init__(self):
        self.d = []

    def ping(self, t: int) -> int:
        while self.d and self.d[0] + 3000 < t:
            heapq.heappop(self.d)
        heapq.heappush(self.d, t)
        return len(self.d)


if __name__ == "__main__":
    s = Solution()
    # mat = [[5]]
    # print(s.diagonalSum(mat))
    # matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    # print(s.spiralOrder(matrix))
    # print(s.generateMatrix(3))
    # ft = FrequencyTracker()
    # ft.add(6)
    # ft.add(9)
    # ft.add(6)
    # ft.add(6)
    # print(ft.hasFrequency(3))
    # s.findSmallestSetOfVertices(5, [[0, 1], [2, 1], [3, 1], [1, 4], [2, 4]])

    # print(s.reverseWords("the sky is blue"))
    # print(s.productExceptSelf([1, 2, 3, 4]))
    # print(s.compress(["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"]))
    # print(s.isSubsequence("abc", "ayiuybdsfac"))
    # print(s.largestAltitude([-4, -3, -2, -1, 4, 3, 2]))
    # print(s.pivotIndex([1, 7, 3, 6, 5, 6]))
    # print(s.closeStrings("uau", "ssx"))
    # print(s.equalPairs([[3, 2, 2, 2], [2, 2, 2, 5], [2, 2, 2, 2], [2, 2, 2, 2]]))
    # print(s.asteroidCollision([-10, 5, 10, -15]))
    # print(s.decodeString("3[a2[c]]"))
    # print(s.topKFrequent([1, 1, 1, 2, 2, 3], 2))
    print(s.kSmallestPairs([-10, -4, 0, 0, 6], [3, 5, 6, 7, 8, 100], 10))
