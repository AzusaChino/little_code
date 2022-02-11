class Solution:
    def isAnagram(self, s, t):
        # N(logN)
        return sorted(s) == sorted(t)
