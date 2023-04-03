from typing import Optional


class MyQueue:
    def __init__(self, cap):
        self.cap = cap
        self.data = [0]*cap
        self.head = 0
        self.tail = 0

    def enqueue(self, val) -> bool:
        if self.full():
            return False
        self.data[self.tail] = val
        self.tail = (self.tail + 1) % self.cap
        return True

    def dequeue(self) -> Optional[int]:
        if self.empty():
            return None
        ret = self.data[self.head]
        self.head = (self.head + 1) % self.cap
        return ret

    def empty(self) -> bool:
        return self.head == self.tail

    def full(self) -> bool:
        return (self.tail + 1) % self.cap == self.head


class StackQueue:
    def __init__(self):
        self.a = []
        self.b = []

    def enqueue(self, val):
        self.a.append(val)

    def dequeue(self):
        if not self.b:
            self.move()
        if self.b:
            return self.b.pop()

    def move(self):
        while self.a:
            self.b.append(self.a.pop())


if __name__ == '__main__':
    q = StackQueue()

    print(q.enqueue(1))
    print(q.enqueue(2))
    print(q.enqueue(3))
    print(q.enqueue(4))

    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
