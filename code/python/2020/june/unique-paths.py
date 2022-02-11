def unique_paths(m, n) -> int:
    dp = [1 for _ in range(n)]
    for i in range(1, m):
        for j in range(1, n):
            dp[j] += dp[j - 1]
    return dp[n - 1]
