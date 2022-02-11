from asyncio import PriorityQueue


class KthLargest:
    def __init__(self, k, nums):
        self.k = k
        self.pq = PriorityQueue()
        for i in nums:
            self.pq.put(i)

    def add(self, n):
        if self.pq.qsize() < self.k:
            self.pq.put(n)

        return self.pq.get_nowait()