#
# @lc app=leetcode id=433 lang=python3
#
# [433] Minimum Genetic Mutation
#
import collections
# @lc code=start
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        queue = collections.deque()
        queue.append([start, start, 0])
        while queue:
            cur, pre, steps = queue.popleft()
            if cur == end:
                return steps
            for s in bank:
                if self.viableMutation(cur, s) and s != pre:
                    queue.append([s, cur, steps + 1 ])
        return -1

    def viableMutation(self, cur, next):
        changes = 0
        for i in range(len(cur)):
            if cur[i] != next[i]:
                changes += 1
        return changes == 1            
# @lc code=end

