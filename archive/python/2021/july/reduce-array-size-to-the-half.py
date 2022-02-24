from typing import Counter, List


class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        c = Counter(arr)
        half = len(arr) // 2
        current = 0
        count = 0
        for k, v in c.most_common():
            if current >= half:
                return count
            current += v
            count += 1
        return count
