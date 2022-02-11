import bisect


class Solution:
    def __init__(self):
        self.ls = []

    def ping(self, t: int) -> int:
        self.ls.append(t)
        return len(self.ls) - bisect.bisect_left(self.ls, t - 3000)
