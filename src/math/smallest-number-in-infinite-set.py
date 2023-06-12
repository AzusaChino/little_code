import heapq


class SmallestInfiniteSet:
    def __init__(self):
        self.index = 0
        self.st = set()
        self.d = []

    def popSmallest(self) -> int:
        # first check addBacked data
        if self.d:
            pop = heapq.heappop(self.d)
            self.st.remove(pop)
            return pop
        self.index += 1
        return self.index

    def addBack(self, num: int) -> None:
        if num in self.st or num > self.index:
            return None
        self.st.add(num)
        heapq.heappush(self.d, num)


if __name__ == "__main__":
    ss = SmallestInfiniteSet()
    print(ss.popSmallest())
    ss.addBack(1)
    print(ss.popSmallest())
    print(ss.popSmallest())
    ss.addBack(1)
    print(ss.popSmallest())
    print(ss.popSmallest())
    print(ss.popSmallest())
