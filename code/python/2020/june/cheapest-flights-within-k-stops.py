import collections
import heapq


def find_cheapest_flights(n, flights, src, dest, k):
    f = collections.defaultdict(dict)
    for a, b, p in flights:
        f[a][b] = p
    heap = [(0, src, k + 1)]
    while heap:
        p, i, k = heapq.heappop(heap)
        if i == dest:
            return p
        if k > 0:
            for j in f[i]:
                heapq.heappush(heap, (p + f[i][j], j, k - 1))
    return -1
