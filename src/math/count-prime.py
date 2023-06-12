class Solution:
    def countPrimes(self, n: int) -> int:
        dp = [True] * n
        for i in range(2, int(n**0.5) + 1):
            if dp[i]:
                for j in range(i**2, n, i):
                    dp[j] = False
        cnt = 0
        for i in range(2, n):
            if dp[i]:
                cnt += 1
        return cnt
