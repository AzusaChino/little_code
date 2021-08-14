from typing import List


class Solution:
    def removeBoxes(self, boxes: List[int]) -> int:
        @cache
        def solve(i, j, k):
            if i == j:
                return 0
            while i + 1 < j and boxes[i] == boxes[i + 1]:
                i, k = i + 1, k + 1
            ans = (k + 1) * (k + 1) + solve(i + 1, j, 0)
            for mid in range(i + 2, j):
                if boxes[i] == boxes[mid]:
                    ans = max(ans, solve(i + 1, mid, 0) + solve(mid, j, k + 1))
            return ans

        return solve(0, len(boxes), 0)
