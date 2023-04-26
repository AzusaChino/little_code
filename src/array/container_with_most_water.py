from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        ret = 0
        while l < r:
            lr, rr = height[l], height[r]
            ret = max(ret, min(lr, rr) * (r - l))
            if lr > rr:
                r -= 1
            else:
                l += 1

        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.maxArea([1, 1]))
