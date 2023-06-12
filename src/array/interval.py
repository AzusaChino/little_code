from typing import List


def intervalSchedule(nums: List[List[int]]) -> int:
    if not nums:
        return 0
    nums.sort(key=lambda x: x[1])
    mx = nums[0][1]
    # base case
    cnt = 1
    for n in nums:
        if n[0] >= mx:
            cnt += 1
            mx = n[1]
    return cnt


def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
    return len(intervals) - intervalSchedule(intervals)
