import collections


def longestPalindrome1(self, s):
    return min(sum(v & ~1 for v in collections.Counter(s).values()) + 1, len(s))


def longestPalindrome2(self, s):
    return len(s) - max(sum(v & 1 for v in collections.Counter(s).values()) - 1, 0)


def longestPalindrome3(self, s):
    odds = sum(v & 1 for v in collections.Counter(s).values())
    return len(s) - odds + bool(odds)
