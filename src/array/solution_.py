from typing import List
from collections import Counter


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ret = []
        for n in nums:
            if ret and ret[-1][1] == n-1:
                ret[-1][1] = n
            else:
                ret.append([n, n])
        return [str(x)+"->"+str(y) if x != y else str(x) for x, y in ret]

    def majorityElement(self, nums: List[int]) -> List[int]:
        cnt = Counter()
        for n in nums:
            cnt[n] += 1
            # maximum 2 majority elements
            if len(cnt) == 3:
                new_cnt = Counter()
                for ele, freq in cnt.items():
                    if freq > 1:
                        new_cnt[ele] = freq - 1
                cnt = new_cnt
        # re-calculate the frequency
        cands = Counter(n for n in nums if n in cnt)
        return [n for n in cands if cands[n] > len(nums)//3]

    def minCost(self, nums, cost):
        def f(x):
            return sum(abs(a - x) * c for a, c in zip(nums, cost))

        l, r = min(nums), max(nums)
        res = f(l)
        while l < r:
            x = (l + r) // 2
            y, z = f(x), f(x + 1)
            res = min(y, z)
            if y < z:
                r = x
            else:
                l = x + 1
        return res
