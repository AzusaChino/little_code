def longest_common_subsequence(s, t) -> int:
    def dp(i, j):
        if i == -1 or j == -1:
            return 0
        if s[i] == t[j]:
            return dp(i - 1, j - 1) + 1
        else:
            return max(dp(i, j - 1), dp(i - 1, j))

    return dp(len(s) - 1, len(t) - 1)


def lcs(s, t) -> int:
    m, n = len(s), len(t)
    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s[i - 1] == t[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[m][n]


def main():
    print(lcs("abcde", "aceb"))


if __name__ == "__main__":
    main()
