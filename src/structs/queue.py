from typing import Optional


class MyQueue:
    def __init__(self):
        self.data = []
        self.out = []

    def push(self, x: int) -> None:
        self.data.append(x)

    def pop(self) -> int:
        self.peek()
        self.out.pop()

    def peek(self) -> int:
        if not self.out:
            while self.data:
                self.out.append(self.data.pop())
        return self.out[-1]

    def empty(self) -> bool:
        return (not self.data) and (not self.out)


class QueueWithArray:
    def __init__(self, cap: int):
        self.cap = cap
        self.data = [-1] * cap
        self.head = 0
        self.tail = 0

    def enqueue(self, val: int) -> bool:
        if self.tail == self.cap:
            # indicates full
            if self.head == 0:
                return False
            else:
                # move ahead
                for i in range(self.head, self.tail):
                    self.data[i - self.head] = self.data[i]
                self.tail -= self.head
                self.head = 0
        self.data[self.tail] = val
        self.tail += 1
        return True

    def dequeue(self) -> Optional[int]:
        if self.head == self.tail:
            return None
        else:
            ret = self.data[self.head]
            self.head += 1
            return ret

    def empty(self):
        return self.head == self.tail


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class QueueWithLinkedList:
    def __init__(self, cap):
        self.head = ListNode(0)
        self.tail = None
        self.cap = cap
        self.len = 0

    def enqueue(self, val) -> bool:
        if self.len >= self.cap:
            return False
        if self.tail:
            self.tail.next = ListNode(val)
            self.tail = self.tail.next
        else:
            self.tail = ListNode(val)
            self.head.next = self.tail
        self.len += 1

    def dequeue(self) -> Optional[int]:
        if self.len > 0:
            node = self.head.next
            self.head.next = self.head.next.next
            self.len -= 1
            return node.val
        else:
            return None


class CircularQueue:
    def __init__(self, cap):
        self.data = [0] * cap
        self.cap = cap
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

    def full(self) -> bool:
        return (self.tail + 1) % self.cap == self.head

    def empty(self) -> bool:
        return self.head == self.tail


if __name__ == "__main__":
    q = CircularQueue(5)
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    q.enqueue(3)
    q.enqueue(3)
    q.enqueue(3)
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
