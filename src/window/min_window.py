from collections import deque
import sys


def min_window(target, nums):
    window = deque()
    ll = sys.maxsize
    r = 0
    while r < len(nums):
        n = nums[r]
        r += 1

        window.append(n)
        while sum(window) >= target:
            ll = min(ll, len(window))
            window.popleft()
    if ll == sys.maxsize:
        return 0
    return ll


if __name__ == "__main__":
    print(min_window(7, [2, 3, 1, 2, 4, 3]))
