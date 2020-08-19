class MyWrongSolution:
    def checkValidString(self, s: str) -> bool:
        stack = []
        starCount = 0
        map = {")": "("}
        for char in s:
            if char in map.values():
                # 遇到左括号 -> 直接入栈
                stack.append(char)
            elif char in map.keys():
                # 遇到右括号 -> 如果栈空或栈顶不是对于的左括号 -> 返回False
                if stack == [] or map[char] != stack.pop():
                    starCount -= 1
            else:
                starCount += 1
        return len(stack) <= starCount


class Solution:
    def checkValidString(self, s):
        cmin = cmax = 0
        for i in s:
            cmax = cmax - 1 if i == ")" else cmax + 1
            cmin = cmin + 1 if i == '(' else max(cmin - 1, 0)
            if cmax < 0: return False
        return cmin == 0


if __name__ == '__main__':
    s = Solution()
    print(s.checkValidString("((())()()(*)(*()(())())())()()((()())((()))(*"))
