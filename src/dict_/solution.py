from collections import Counter


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        return not Counter(ransomNote) - Counter(magazine)

    def isIsomorphic(self, s: str, t: str) -> bool:
        # explain this
        return [*map(s.index, s)] == [*map(t.index, t)]
