class Solution:
    # 1. 一直取模
    # 2. log2 = int
    # 3. 位运算
    def power(self, n):
        return n > 0 and not n & (n - 1)
