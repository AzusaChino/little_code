from typing import Collection
import collections


class Solution:
    def intersect(self, nums1, nums2):
        C = Collection.Counter
        return list((C(nums1) & C(nums2)).elements())

    def intersect(self, nums1, nums2):
        return list(
            (collections.Counter(nums1) & collections.Counter(nums2)).elements()
        )
