from collections import deque
from typing import Optional


class MyStack:
    def __init__(self, cap):
        self.cap = cap
        self.data = [0] * cap
        self.tail = 0

    def push(self, val) -> bool:
        if self.full():
            return False
        self.data[self.tail] = val
        self.tail += 1
        return True

    def pop(self) -> Optional[int]:
        if self.empty():
            return None
        self.tail -= 1
        ret = self.data[self.tail]
        return ret

    def empty(self) -> bool:
        return self.tail == 0

    def full(self) -> bool:
        return self.tail == self.cap


class QueueStack:
    def __init__(self):
        self.s = deque()

    def push(self, val):
        self.s.append(val)
        for _ in range(len(self.s), 1, -1):
            self.s.append(self.s.popleft())

    def pop(self):
        if self.s:
            return self.s.popleft()


if __name__ == '__main__':
    s = QueueStack()
    print(s.push(1))
    print(s.push(2))
    print(s.push(4))
    print(s.push(5))

    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(s.pop())
