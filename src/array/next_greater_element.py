from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        greater = next_greater_element(nums2)
        d = {}
        for i in range(0, len(nums2)):
            d[nums2[i]] = greater[i]
        print(d)
        ret = [0] * len(nums1)
        for i in range(0, len(nums1)):
            ret[i] = d[nums1[i]]
        return ret


def next_greater_element(nums: List[int]) -> List[int]:
    ret = [0] * len(nums)
    s = []
    for i in range(len(nums) - 1, -1, -1):
        while s and s[-1] <= nums[i]:
            s.pop()
        if s:
            ret[i] = s[-1]
        else:
            ret[i] = -1
        s.append(nums[i])
    return ret


if __name__ == "__main__":
    # [4, 2, 4, -1, -1]
    print(next_greater_element([2, 1, 2, 4, 3]))
