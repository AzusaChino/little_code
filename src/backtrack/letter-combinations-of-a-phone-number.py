from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        d = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }
        N = len(digits)
        ret = []
        track = []

        def backtrack(start, track):
            if len(track) == N:
                ret.append("".join(track))
            for i in range(start, N):
                for c in d[digits[i]]:
                    track.append(c)
                    backtrack(i + 1, track)
                    track.pop()

        backtrack(0, track)
        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.letterCombinations("23"))
