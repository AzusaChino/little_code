def eraseOverlapIntervals(self, intervals):
    end = float('-inf')
    erased = 0
    for i in sorted(intervals, key=lambda i: i.end):
        if i.start >= end:
            end = i.end
        else:
            erased += 1
    return erased

def eraseOverlapIntervals(self, intervals):
    return len(intervals) - reduce(lambda res, i: (res[0] + 1, i.end) if i.start >= res[1] else res,
                                       sorted(intervals, key=lambda i: i.end), (0, -float('inf')))[0]