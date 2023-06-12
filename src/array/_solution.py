from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ret = []
        for n in nums:
            if ret and ret[-1][1] == n-1:
                ret[-1][1] = n
            else:
                ret.append([n, n])
        return [str(x)+"->"+str(y) if x != y else str(x) for x, y in ret]
