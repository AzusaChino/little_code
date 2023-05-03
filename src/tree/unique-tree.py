from functools import cache
from index import TreeNode


class Solution:
    def numTrees(self, n: int) -> int:

        if n <= 1:
            return 1
        return sum(self.numTrees(i - 1) * self.numTrees(n - i) for i in range(1, n + 1))

    @cache
    def numTrees(self, n: int) -> int:
        if n <= 1:
            return 1
        return sum(self.numTrees(i - 1) * self.numTrees(n - i) for i in range(1, n + 1))

    def numTrees(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0], dp[1] = 1, 1
        for i in range(2, n + 1):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]
        return dp[n]

    def generateTrees(self, n):
        def generate(first, last):
            trees = []
            for root in range(first, last + 1):
                for left in generate(first, root - 1):
                    for right in generate(root + 1, last):
                        node = TreeNode(root)
                        node.left = left
                        node.right = right
                        trees += [node]
            return trees or [None]

        return generate(1, n)
