from typing import Collection


class Solution:
    def numMatchingSubseq(self, S, words):
        waiting = Collection.defaultdict(list)
        for it in map(iter, words):
            waiting[next(it)].append(it)
        for c in S:
            for it in waiting.pop(c, ()):
                waiting[next(it, None)].append(it)
        return len(waiting[None])
