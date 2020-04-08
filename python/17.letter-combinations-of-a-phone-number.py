#
# @lc app=leetcode id=17 lang=python3
#
# [17] Letter Combinations of a Phone Number
#

# @lc code=start
class Solution:
    m = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', 
        '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
    def letterCombinations(self, digits: str) -> List[str]:
        length = len(digits)
        if length == 0:
            return []
        elif length == 1:
            return list(self.m[digits])
        prev = self.letterCombinations(digits[:-1])
        addtion = self.m[digits[-1]]
        return [s+c for s in prev for c in addtion]
        
# @lc code=end

