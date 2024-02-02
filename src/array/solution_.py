from typing import List
from collections import Counter


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ret = []
        for n in nums:
            if ret and ret[-1][1] == n - 1:
                ret[-1][1] = n
            else:
                ret.append([n, n])
        return [str(x) + "->" + str(y) if x != y else str(x) for x, y in ret]

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
        return [n for n in cands if cands[n] > len(nums) // 3]

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

    def sumSubarrayMins(self, A: List[int]) -> int:
        A = [0] + A
        result = [0] * len(A)
        stack = [0]
        for i in range(len(A)):
            while A[stack[-1]] > A[i]:
                stack.pop()
            j = stack[-1]
            result[i] = result[j] + (i - j) * A[i]
            stack.append(i)
        return sum(result) % (10**9 + 7)

    def sequentialDigits(self, low, high):
        result = []
        for num in range(low, high + 1):
            # Check if all digits are distinct
            if len(set(str(num))) != len(str(num)):
                continue

            # Check if digits are consecutive
            digits = [int(d) for d in str(num)]
            is_sequential = True
            for i in range(1, len(digits)):
                if digits[i] != digits[i - 1] + 1:
                    is_sequential = False
                    break

            if is_sequential:
                result.append(num)

        return result
