from typing import List


def longest_lis(nums: List[int]) -> int:
    # dp[i] means the longest increasing sequence end with i
    # adding base case
    n = len(nums)
    dp = [1 for _ in range(n)]
    for i in range(n):
        for j in range(i - 1, -1, -1):
            if nums[i] > nums[j]:
                dp[i] = max(dp[i], dp[j] + 1)

    return max(dp)


def max_sub_array(nums: List[int]) -> int:
    n = len(nums)
    # nums itself is base case, every num stands for dp[i], as current max sub array
    dp = nums[:]
    for i in range(1, n):
        dp[i] = max(dp[i], dp[i - 1] + nums[i])
    return max(dp)


def max_common_sub_sequence(s: str, t: str) -> int:
    # dp[i][j] means max common sub sequences for i-size, j-size string
    m, n = len(s), len(t)
    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    # base case
    # dp[i][0] => no common, dp[0][j] => no common
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s[i - 1] == t[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                # 处理上个字符串不相等的情况
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])

    return dp[m][n]


def edit_distance(s: str, t: str) -> int:
    m, n = len(s), len(t)
    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    # base case, from empty string to target, we need m or n modifications
    for i in range(m + 1):
        dp[i][0] = i
    for j in range(n + 1):
        dp[0][j] = j
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s[i - 1] == t[j - 1]:
                # no modification
                dp[i][j] = dp[i - 1][j - 1]
            else:
                dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
    return dp[m][n]


def max_palidromic_sub_sequences(s: str) -> int:
    n = len(s)
    dp = [[0 for _ in range(n)] for _ in range(n)]
    # base case, dp[i][i] is 1
    for i in range(n):
        dp[i][i] = 1
    for i in range(n - 2, -1, -1):
        for j in range(i + 1, n):
            if s[i] == s[j]:
                dp[i][j] = dp[i + 1][j - 1] + 2
            else:
                dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])

    return dp[0][n - 1]


if __name__ == "__main__":
    print(longest_lis([3, 5, 1, 7, 2, 8]))
    print(max_sub_array([-3, 4, -1, 2, -6, 1]))
    print(max_common_sub_sequence("babcde", "ace"))
    print(edit_distance("rad", "apple"))
    print(max_palidromic_sub_sequences("apple"))
