from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * len(s)
        for i in range(len(s)):
            for w in wordDict:
                # substr & compare
                if w == s[i - len(w) + 1 : i + 1] and (
                    # start 0
                    i - len(w) == -1
                    # previous is True
                    or dp[i - len(w)]
                ):
                    dp[i] = True

        return dp[-1]
