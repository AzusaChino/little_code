class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Solution:
    def insert(self, intervals, new_interval):
        s, e = new_interval.start, new_interval.end
        parts = merge, left, right = [], [], []
        for i in intervals:
            parts[(i.end < s) - (i.start > e)].append(i)
        if merge:
            s = min(s, merge[0].start)
            e = max(e, merge[-1].end)
        return left + [Interval(s, e)] + right
