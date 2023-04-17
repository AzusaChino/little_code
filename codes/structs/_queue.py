from typing import Optional

import heapq


class MyQueue:
    def __init__(self, cap):
        self.cap = cap
        self.data = [0] * cap
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


if __name__ == "__main__":
    # Create a priority queue
    pq = []

    # Add some items to the queue
    heapq.heappush(pq, (10, "ten"))
    heapq.heappush(pq, (5, "five"))
    heapq.heappush(pq, (2, "two"))

    # Get the highest priority item from the queue
    item, priority = heapq.heappop(pq)
    print(item, priority)
    # Output: ten 10

    # Get all the items from the queue
    items = []
    while pq:
        item, priority = heapq.heappop(pq)
        items.append((item, priority))

    print(items)
    # Output: [(10, 10), (5, 5), (2, 2)]
