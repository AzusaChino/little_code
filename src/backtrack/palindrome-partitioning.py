from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        """
        从 s 的头部开始暴力穷举，如果发现 s[0..i] 是一个回文子串
        那么我们就可以把 s 切分为 s[0..i] 和 s[i+1..]
        然后我们去尝试把 s[i+1..] 去暴力切分成多个回文子串即可
        """
        ret = []
        track = []

        def backtrack(s, step, track):
            if step == len(s):
                ret.append(track[:])
            for i in range(step, len(s)):
                if not is_palidrome(s, step, i):
                    continue
                track.append(s[step : i + 1])
                backtrack(s, i + 1, track)
                track.pop()

        def is_palidrome(s, l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        backtrack(s, 0, track)
        return ret
