from bisect import bisect
from typing import List

import heapq


def findRightInterval(intervals):
    starts = sorted([I.start, i] for i, I in enumerate(intervals)) + [[float('inf'), -1]]
    return [starts[bisect(starts, [I.end])][1] for I in intervals]


class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        heap, result = [], [-1] * len(intervals)
        for idx, interval in sorted(enumerate(intervals), key=lambda enum: enum[1]):
            while heap and heap[0][0] <= interval[0]:
                _, i = heapq.heappop(heap)
                result[i] = idx
                heapq.heappush(heap, (interval[1], idx))
        return result
