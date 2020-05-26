import collections


def max_uncrossed_lines(A, B):
    dp, m, n = collections.defaultdict(int), len(A), len(B)
    for i in range(m):
        for j in range(n):
            dp[i, j] = max(dp[i - 1, j - 1] + (A[i] == B[j]), dp[i - 1, j], dp[i, j - 1])
    return dp[m - 1, n - 1]


def max_uncrossed_lines2(A, B):
    m, n = len(A), len(B)
    dp = [0] * (n + 1)
    for i in range(m):
        for j in range(n)[::-1]:
            if A[i] == B[j]:
                dp[j + 1] = dp[j] + 1
        for j in range(n):
            dp[j + 1] = max(dp[j + 1], dp[j])
    return dp[n]
