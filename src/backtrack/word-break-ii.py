from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        N = len(s)
        st = set(wordDict)
        ret = []
        track = []

        def backtrack(s, start, track):
            if start == N:
                ret.append(" ".join(track))
            for i in range(start, N):
                cur = s[start : i + 1]
                if cur not in st:
                    continue
                track.append(cur)
                backtrack(s, i + 1, track)
                track.pop()

        backtrack(s, 0, track)
        return ret


if __name__ == "__main__":
    s = Solution()
    print(
        s.wordBreak(
            "pineapplepenapple", ["apple", "pen", "applepen", "pine", "pineapple"]
        )
    )
