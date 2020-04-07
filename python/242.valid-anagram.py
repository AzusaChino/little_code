#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#
# 1. clarification
# 2. possible solutions -> optimal(time & space)
# 3. code
# 4. test cases
# @lc code=start
class Solution:
    # 1. 暴力 sort
    # 2. hash, map
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
    
    def isA(self, s, t):
        dict1, dict2 = {},{}
        for item in s:
            dict1[item] = dict1.get(item, 0) + 1
        for item in t:
            dict2[item] = dict2.get(item, 0) + 1
        return dict1 == dict2


# @lc code=end

