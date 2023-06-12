from typing import List
import heapq


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        pq = []
        for st in stones:
            # using negative to simulate max_heap
            heapq.heappush(pq, -st)
        # loop n-1 times
        while len(pq) > 1:
            h = heapq.heappop(pq)
            s = heapq.heappop(pq)
            if h - s != 0:
                heapq.heappush(pq, h - s)
        if pq:
            return -pq[0]
        return 0

    def generateParenthesis(self, n: int) -> List[str]:
        ret = []

        def helper(l, r, track):
            if l < 0 or r < 0:
                return
            # using ) more then (
            if r < l:
                return
            if l == 0 and r == 0:
                ret.append("".join(track))
                return

            track.append("(")
            helper(l - 1, r, track)
            track.pop()

            track.append(")")
            helper(l, r - 1, track)
            track.pop()

        track = []
        helper(n, n, track)
        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.lastStoneWeight([2, 7, 4, 1, 8, 1]))
    print(s.lastStoneWeight([1, 1]))
    print(s.generateParenthesis(3))
