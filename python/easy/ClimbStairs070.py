class Solution:
    def climb(self, n):
        if n == 1: return 1
        if n == 2: return 2
        ret = [-1 for _ in range(n)]
        ret[0], ret[1] = 1, 2
        return self.dp(n - 1, ret)

    def dp(self, n, ret):
        if ret[n] == -1:
            ret[n] = self.dp(n - 1, ret) + self.dp(n - 2, ret)
        return ret[n]


def c(n):
    if n == 1: return 1
    a, b = 1, 2
    for _ in range(2, n):
        a, b = b, a + b
    return b


if __name__ == '__main__':
    print(Solution().climb(10))
