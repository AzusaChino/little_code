from typing import List


class Solution:
    def check(self, coordinates: List[int]):
        (x0, y0), (x1, y1) = coordinates[:2]
        for x, y in coordinates:
            if (x1-x0) * (y-y1) != (y1-y0) * (x-x1):
                return False
        return True
