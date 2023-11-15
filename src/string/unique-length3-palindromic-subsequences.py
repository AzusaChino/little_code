class Solution:
    def countPalindromicSubsequence(self, s):
        return sum([len(set(s[s.index(c) + 1 : s.rindex(c)])) for c in set(s)])
