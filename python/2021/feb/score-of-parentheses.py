class Solution:
    def scoreOfParentheses(self, S: str) -> int:
        return eval(S.replace(')(', ')+(').replace('()', '1').replace(')', ')*2'))
