#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#
# 最近相关性 -- 栈
# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        stack, match = [], {')':'(',']':'[','}':'{'}
        for ch in s:
            if ch in match:
                if not (stack and stack.pop() == match[ch]):
                    return False
            else:
                stack.append(ch)
        return not stack

# @lc code=end

