from operator import add
from typing import List
from operator import add


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        for _ in range(1, numRows):
            map_ = map(add, [0] + res[-1] + [0])
            res.append(list(map_))
        return res if numRows else []
