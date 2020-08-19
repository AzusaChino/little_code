class Solution:
    def valid(self, s: str) -> bool:
        stack = []
        map = {"]": "[", "}": "{", ")": "("}
        for char in s:
            if char in map.values():
                # 遇到左括号 -> 直接入栈
                stack.append(char)
            elif char in map.keys():
                # 遇到右括号 -> 如果栈空或栈顶不是对于的左括号 -> 返回False
                if stack == [] or map[char] != stack.pop():
                    return False
            else:
                # 不是题目所定义的符号
                return False
        return stack == []
