import numpy as np
import itertools


class Solution:
    def matrixReshape(self, nums, r, c):
        try:
            return np.reshape(nums, (r, c)).tolist()
        except:
            return nums


def matrixReshape(nums, r, c):
    if r * c != len(nums) * len(nums[0]):
        return nums
    it = itertools.chain(*nums)
    return [list(itertools.islice(it, c)) for _ in range(r)]
