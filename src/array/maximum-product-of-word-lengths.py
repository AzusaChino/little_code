from typing import List


class Solution:
    def maxProduct(self, words: List[str]) -> int:
        words.sort(key=lambda x: -len(x))
        N = len(words)

        def get_bitmask(s):
            mask = 0
            for i in range(len(s)):
                mask |= 1 << (ord(s[i]) - ord("a"))
            return mask

        masks = [get_bitmask(m) for m in words]
        mx = 0
        # reversed order, once find, break
        for i in range(N - 1):
            if len(words[i]) ** 2 <= mx:
                break
            for j in range(i + 1, N):
                if (masks[i] & masks[j]) == 0:
                    mx = max(mx, len(words[i]) * len(words[j]))
                    break
        return mx
