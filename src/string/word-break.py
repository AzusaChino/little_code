from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        N = len(s)
        dp = [False] * N
        for i in range(N):
            for w in wordDict:
                # splice s and compare
                if i < len(w) - 1:
                    continue
                if w == s[i - len(w) + 1 : i + 1] and (
                    i - len(w) == -1 or dp[i - len(w)]
                ):
                    dp[i] = True
        return dp[N]
    
    def wordBreak_ii(self, s: str, wordDict: List[str]) -> List[str]:
        N = len(s)
        st = set(wordDict)
        ret = []
        track = []

        def backtrack(start, track):
            if start == N:
                ret.append(" ".join(track))
            
            for i in range(start, N):
                cur = s[start: i+1]
                if cur not in st:
                    continue
                track.append(cur)
                backtrack(i+1, track)
                track.pop()
        
        backtrack(0, track)
        return ret
