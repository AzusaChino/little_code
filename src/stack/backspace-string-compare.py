class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        a, b = [], []
        for ch in s:
            if ch == "#" and a:
                a.pop()
            else:
                a.append(ch)
        for ch in t:
            if ch == "#" and b:
                b.pop()
            else:
                b.append(ch)
        if len(a) != len(b):
            return False
        for i in range(len(a)):
            if a[i] != b[i]:
                return False
        return True
