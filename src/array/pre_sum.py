from typing import List


def presum(nums: List[int], i, j):
    n = len(nums)
    pre = [0] * (n + 1)
    for k in range(1, n + 1):
        pre[k] = pre[k - 1] + nums[k - 1]
    print(pre)
    return pre[j] - pre[i]

def longestCommomPrefix(strs: List[str]) -> str:
    pass



if __name__ == "__main__":
    print(presum([1, 2, 3, 4, 5, 6, 7], 1, 5))

