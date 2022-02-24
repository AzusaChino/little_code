from typing import List


class Solution:

    def h_index(self, citations: List[int]) -> int:
        hIndex = 0
        citations.sort(reverse=True)
        for i, c in enumerate(citations, start=1):
            if c >= i:
                hIndex = i
            else:
                break
        return hIndex
