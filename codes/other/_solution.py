from collections import Counter, defaultdict, deque
import heapq
import sys
from typing import List, Optional


class Node:
    def __init__(self, x: int, next: "Node" = None, random: "Node" = None):
        self.val = int(x)
        self.next = next
        self.random = random


class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = None
        self.right = None


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        You are given an array prices where prices[i] is the price of a given stock on the ith day.
        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
        """
        if not prices:
            return 0
        l = prices[0]
        sofar = 0
        for i in range(1, len(prices)):
            if prices[i] < l:
                l = prices[i]
            sofar = max(sofar, prices[i] - l)
        return sofar

    def max_profit(self, prices: List[int]) -> int:
        """
        You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
        On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
        However, you can buy it then immediately sell it on the same day.
        Find and return the maximum profit you can achieve.
        """
        if not prices:
            return 0
        N = len(prices)
        dp = [[0, 0] for _ in range(N)]
        """
        dp[i][0] not hold stock
        dp[i][1] hold stock, and need to sell it
        the final result it max(dp[n][0])
        """
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1, N):
            dp[i][0] = max(dp[i - 1][1] + prices[i], dp[i - 1][0])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i], -prices[i])
        print(dp)
        mx = 0
        for i in range(1, N):
            mx = max(mx, dp[i][0])
        return mx

    def isMatch(self, s: str, p: str) -> bool:
        """
        Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).
        """
        """
        1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
        2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
        3, If p.charAt(j) == '*': 
        here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
        """
        if not s or not p:
            return False
        M, N = len(s), len(p)
        dp = [[False] * (N + 1) for _ in range(M + 1)]
        dp[0][0] = True

        # s = "", p = #*#*#*#*.
        for j in range(2, N + 1, 2):
            if p[j - 1] == "*" and dp[0][j - 2]:
                dp[0][j] = True

        for i in range(M):
            for j in range(N):
                if p[j] == "." or s[i] == p[j]:
                    dp[i + 1][j + 1] = dp[i][j]
                if p[j] == "*":
                    if p[j - 1] != s[i] and p[j - 1] != ".":
                        # 不匹配, p 跳两格
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]
                    else:
                        dp[i + 1][j + 1] = (
                            dp[i][j + 1] or dp[i + 1][j] or dp[i + 1][j - 1]
                        )
        return dp[M][N]

    def maxVowels(self, s: str, k: int) -> int:
        d = {
            "a": 1,
            "e": 1,
            "i": 1,
            "o": 1,
            "u": 1,
        }

        l = r = 0
        cur = 0
        mx = 0
        while r < len(s):
            rc = s[r]
            r += 1
            if rc in d:
                cur += 1

            if k == (r - l):
                mx = max(mx, cur)
                lc = s[l]
                l += 1
                if lc in d:
                    cur -= 1

        return mx

    def trap(self, height: List[int]) -> int:
        """
        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
        water[i] = min(
           # 左边最高的柱子
           max(height[0..i]),
           # 右边最高的柱子
           max(height[i..end])
        ) - height[i]
        """
        if not height:
            return 0
        N = len(height)
        ret = 0

        l_max, r_max = [0] * N, [0] * N
        l_max[0] = height[0]
        r_max[N - 1] = height[N - 1]

        for i in range(1, N):
            l_max[i] = max(l_max[i - 1], height[i])
        for j in range(N - 2, -1, -1):
            r_max[j] = max(r_max[j + 1], height[j])

        for i in range(1, N - 1):
            ret += min(l_max[i], r_max[i]) - height[i]
        return ret

    def search(self, nums: List[int], target: int) -> int:
        N = len(nums)
        l = 0
        r = N - 1
        while l <= r:
            m = l + (r - l) // 2
            if nums[m] == target:
                return m
            if nums[l] <= nums[m]:
                if nums[l] <= target < nums[m]:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if nums[m] < target <= nums[r]:
                    l = m + 1
                else:
                    r = m - 1
        return -1

    def isMatch_(self, s: str, p: str) -> bool:
        """
        44. Wildcard Matching
        Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

        '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).
        The matching should cover the entire input string (not partial).
        """
        M, N = len(s), len(p)
        dp = [[False] * (N + 1) for _ in range(M + 1)]
        dp[0][0] = True
        for j in range(1, N + 1):
            if p[j - 1] == "*":
                dp[0][j] = True
            else:
                break
        for i in range(1, M + 1):
            for j in range(1, N + 1):
                if s[i - 1] == p[j - 1] or p[j - 1] == "?":
                    dp[i][j] = dp[i - 1][j - 1]
                if p[j - 1] == "*":
                    dp[i][j] = dp[i][j - 1] or dp[i - 1][j]

        return dp[M][N]

    def minFlipsMonoIncr(self, s: str) -> int:
        a = b = 0
        for c in s:
            if c == "1":
                a += 1
            else:
                b += 1
            b = min(a, b)
        return b

    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        N = len(gas)
        for i in range(N):
            cur = gas[i]
            j = i + 1
            ok = True
            while (j % N) != i:
                n_j = j % N
                cur -= cost[n_j]
                if cur <= 0:
                    ok = False
                    break
                cur += gas[n_j]
                j += 1
            if ok:
                return i + 1
        return -1

    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        LD = days[-1]
        dp = [0 for _ in range(LD + 1)]
        for i in range(LD + 1):
            if i not in days:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(
                    dp[max(0, i - 1)] + costs[0],
                    dp[max(0, i - 7)] + costs[1],
                    dp[max(0, i - 30)] + costs[2],
                )
        return dp[-1]

    def generateMatrix(self, n: int) -> List[List[int]]:
        D = [[0] * n for _ in range(n)]
        # top bound, bottom bound
        tb, bb = 0, n - 1
        # left bound, right bound
        lb, rb = 0, n - 1
        num = 1
        t = n**2
        while num <= t:
            if tb <= bb:
                for i in range(lb, rb + 1):
                    D[tb][i] = num
                    num += 1
                tb += 1
            if lb <= rb:
                for i in range(tb, bb + 1):
                    D[i][rb] = num
                    num += 1
                rb -= 1
            if tb <= bb:
                for i in range(rb, lb - 1, -1):
                    D[bb][i] = num
                    num += 1
                bb -= 1
            if lb <= rb:
                for i in range(bb, tb - 1, -1):
                    D[i][lb] = num
                    num += 1
                lb += 1
        return D

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

        构造二叉树，第一件事一定是找根节点，然后想办法构造左右子树。
        """
        P, I = len(preorder), len(inorder)
        im = {}
        for i, v in enumerate(inorder):
            im[v] = i

        def build(preorder, preStart, preEnd, inorder, inStart, inEnd, valToIndex):
            if preStart > preEnd:
                return None

            # root 节点对应的值就是前序遍历数组的第一个元素
            rootVal = preorder[preStart]
            # rootVal 在中序遍历数组中的索引
            index = valToIndex[rootVal]

            leftSize = index - inStart

            # 先构造出当前根节点
            root = TreeNode(rootVal)

            # 递归构造左右子树
            root.left = build(
                preorder,
                preStart + 1,
                preStart + leftSize,
                inorder,
                inStart,
                index - 1,
                valToIndex,
            )

            root.right = build(
                preorder,
                preStart + leftSize + 1,
                preEnd,
                inorder,
                index + 1,
                inEnd,
                valToIndex,
            )
            return root

        return build(preorder, 0, P - 1, inorder, 0, I - 1, im)

    def numSubseq(self, nums: List[int], target: int) -> int:
        modo = 10**9 + 7
        N = len(nums)
        nums.sort()

        self.ret = 0
        self.r = []

        def backtrack(start, arr):
            if arr:
                sm = arr[0] + arr[-1]
                if sm > target:
                    return
                if 0 < sm <= target:
                    self.ret += 1
                    self.r.append(arr[:])
            for i in range(start, N):
                if arr:
                    if arr[0] + nums[i] > target:
                        break
                arr.append(nums[i])
                backtrack(i + 1, arr)
                arr.pop()

        backtrack(0, [])
        print(self.r)
        return self.ret % modo

    def numSubseq(self, nums: List[int], target: int) -> int:
        N = len(nums)
        nums.sort()
        l, r = 0, N - 1
        ret = 0
        mod = 10**9 + 7
        while l <= r:
            if nums[l] + nums[r] > target:
                r -= 1
            else:
                ret += pow(2, r - l, mod)
                l += 1
        return ret % mod

    def largestRectangleArea(self, heights: List[int]) -> int:
        ret = 0
        st = []
        # force pop all element (mono_increase_stack)
        heights += [0]
        for i, v in enumerate(heights):
            while st and heights[st[-1]] >= v:
                H = heights[st.pop()]
                W = i if not st else i - st[-1] - 1
                ret = max(ret, H * W)
            st.append(i)
        return ret

    def longestSubstring(self, s: str, k: int) -> int:
        if not s:
            return 0
        d = [0] * 26
        for c in s:
            d[ord(c) - ord("a")] += 1
        check_whole = True
        for i in range(26):
            if 0 < d[i] < k:
                check_whole = False
        if check_whole:
            return len(s)
        ret = start = cur = 0
        while cur < len(s):
            if d[ord(s[cur]) - ord("a")] < k:
                ret = max(ret, self.longestSubstring(s[start:cur], k))
                start = cur + 1
            cur += 1

        ret = max(ret, self.longestSubstring(s[start:], k))
        return ret

    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        N = len(matrix)
        pq = []
        for i in range(N):
            # 初始化优先级队列，把每一行的第一个元素装进去
            heapq.heappush(pq, [matrix[i][0], i, 0])
        返回值 = -1

        # 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while pq and k:
            cur = heapq.heappop(pq)
            返回值, i, j = cur
            k -= 1
            if j + 1 < N:
                heapq.heappush(pq, [matrix[i][j + 1], i, j + 1])

        return 返回值

    def serialize(self, root):
        def doit(node):
            if node:
                vals.append(str(node.val))
                doit(node.left)
                doit(node.right)
            else:
                vals.append("#")

        vals = []
        doit(root)
        return " ".join(vals)

    def deserialize(self, data):
        def doit():
            val = next(vals)
            if val == "#":
                return None
            node = TreeNode(int(val))
            node.left = doit()
            node.right = doit()
            return node

        vals = iter(data.split())
        return doit()

    def findDuplicate(self, nums: List[int]) -> int:
        for n in nums:
            idx = abs(n)
            if nums[idx] < 0:
                return idx
            nums[idx] = -nums[idx]
        return len(nums)

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.mx = -sys.maxsize

        def helper(node):
            if not node:
                return 0
            l = max(0, helper(node.left))
            r = max(0, helper(node.right))

            self.mx = max(self.mx, node.val + l + r)
            return max(l, r) + node.val

        helper(root)
        return self.mx

    def copyRandomList(self, head: "Optional[Node]") -> "Optional[Node]":
        D = {}
        dummy = Node(0)
        d_ = dummy
        cur = head
        while cur:
            d_.next = Node(cur.val)
            D[cur] = d_.next
            cur = cur.next
            d_ = d_.next

        for n in D.keys():
            new_n = D[n]
            if n.random:
                new_n.random = D[n.random]

        return dummy.next

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        N = len(beginWord)
        q = deque()
        q.append(beginWord)
        visited = set()
        visited.add(beginWord)
        st = set(wordList)
        step = 1
        while q:
            sz = len(q)
            for _ in range(sz):
                cur = q.popleft()
                if endWord == cur:
                    return step
                for i in range(N):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        new_cur = cur[:i] + c + cur[i + 1 :]
                        if new_cur in st and new_cur not in visited:
                            visited.add(new_cur)
                            q.append(new_cur)

            step += 1

        return 0


if __name__ == "__main__":
    s = Solution()
    arr = [3, 2, 6, 5, 0, 3]
    # print(s.isMatch("aab", "c*a*b"))
    # print(s.maxVowels("abciiidef", 3))
    # print(s.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
    # print(s.search([4, 5, 6, 7, 0, 1, 2], 0))
    # print(s.isMatch_("aab", "c*a*b"))
    # print(s.minFlipsMonoIncr("10011111110010111011"))
    print(s.canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2]))
    print(s.canCompleteCircuit([2, 3, 4], [3, 4, 3]))
    print(s.generateMatrix(3))
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]

    # print(s.numSubseq([2, 3, 3, 4, 6, 7], 12))
    print(
        s.ladderLength(
            "leet", "code", ["lest", "leet", "lose", "code", "lode", "robe", "lost"]
        )
    )
