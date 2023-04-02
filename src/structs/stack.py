from typing import Optional


class Solution:
    dict = {")": "(", "]": "[", "}": "{"}

    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in self.dict.values():
                stack.append(ch)
            elif ch in self.dict.keys():
                if stack == [] or stack.pop() != self.dict[ch]:
                    return False
            else:
                return False
        return True


class MyStack:
    def __init__(self, cap):
        self.data = [0] * cap
        self.cap = cap
        self.index = -1

    def push(self, val) -> bool:
        if self.index >= self.cap - 1:
            return False
        self.index += 1
        self.data[self.index] = val
        return True

    def pop(self) -> Optional[int]:
        if self.index < 0:
            return None
        ret = self.data[self.index]
        self.index -= 1
        return ret

    def empty(self) -> bool:
        return self.index < 0


if __name__ == "__main__":
    s = MyStack(3)
    s.push(1)
    s.push(2)
    s.push(3)
    s.push(4)
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(s.pop())
