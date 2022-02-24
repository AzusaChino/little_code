from typing import List


class Solution:
    def reverse_string(self, s: List[str]) -> None:
        self.helper(s, 0, len(s) - 1)

    def helper(self, s, l, r):
        if l == r or l - r == 1:
            return
        s[l], s[r] = s[r], s[l]
        self.helper(s, l + 1, r - 1)
