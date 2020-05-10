#
# @lc app=leetcode id=678 lang=python3
#
# [678] Valid Parenthesis String
#

# @lc code=start
class Solution:
    def checkValidString(self, s: str) -> bool:
        low, high = 0,0 
        for c in s:
            if c == '(':
                low+=1
                high += 1
            elif c == ')':
                if low > 0:
                    low -=1
                high -= 1
            else:
                if low > 0:
                    low -= 1
                high += 1
            if high < 0:
                return False
        return low == 0
# @lc code=end

