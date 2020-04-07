#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums):
        return reduce(lambda ps, n:[p[:i] + [n]+p[i:]
        for p in ps
        for i in range((p+[n]).index(n)+1)], nums, [[]])
    def permuteUnique1(self, nums: List[int]) -> List[List[int]]:
        ps = [[]]
        for n in nums:
            ps = [p[:i] + [n] + p[i:]
            for p in ps
            for i in range((p + [n]).index(n) + 1)]
        return ps
# @lc code=end

