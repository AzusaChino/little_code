import collections


class MinStack:
    def __init__(self):
        self.data = []
        self.min = []

    def push(self, val: int) -> None:
        self.data.append(val)
        # calc min
        if not self.min or self.min[-1] >= val:
            self.min.append(val)
        else:
            self.min.append(self.min[-1])

    def pop(self) -> None:
        self.data.pop()
        self.min.pop()

    def top(self) -> int:
        return self.data[-1]

    def getMin(self) -> int:
        return self.min[-1]


class Stack:
    def __init__(self):
        self._queue = collections.deque()

    def push(self, x):
        self._queue.append(x)
        # every time, move the last element to the front
        self._queue.rotate(1)

    def pop(self):
        return self._queue.popleft()

    def top(self):
        return self._queue[0]

    def empty(self):
        return not len(self._queue)
