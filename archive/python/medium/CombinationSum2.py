from urllib3.connectionpool import xrange


class Solution(object):
    def combinationSum2(self, candidates, target):
        candidates.sort()
        dp = [set() for _ in xrange(target + 1)]
        dp[0].add(())
        for num in candidates:
            for t in xrange(target, num - 1, -1):
                for prev in dp[t - num]:
                    dp[t].add(prev + (num,))
        return list(dp[-1])


if __name__ == '__main__':
    print(Solution().combinationSum2([1, 1, 2, 5, 6, 7, 10], 8))
