def merge(intervals):
    res = []
    for i in sorted(intervals, key=lambda i: i.start):
        if res and i.start <= res[-1].end:
            res[-1].end = max(res[-1].end, i.end)
        else:
            res += i
    return res

