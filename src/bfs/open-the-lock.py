from collections import deque
from typing import List


class Solution:
    def openLock(self, deadends, target):
        depth = 0
        visited = set(deadends)
        q = deque()
        q.append("0000")

        while q:
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                if node == target:
                    return depth
                if node in visited:
                    continue
                visited.add(node)
                q.extend(self.successors(node))
            depth += 1
        return -1

    def successors(self, src):
        res = []
        for i, ch in enumerate(src):
            num = int(ch)
            res.append(src[:i] + str((num - 1) % 10) + src[i + 1 :])
            res.append(src[:i] + str((num + 1) % 10) + src[i + 1 :])
        return res


def main():
    s = Solution()
    ends = ["0201", "0101", "0102", "1212", "2002"]
    print(s.openLock(ends, "0202"))


if __name__ == "__main__":
    main()
