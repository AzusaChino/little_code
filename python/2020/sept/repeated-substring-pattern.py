class Solution:
    def repeatedSubstringPattern(self, str):
        return str in (2 * str)[1:-1]
