from typing import Collection
import collections

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        cnt = Collection.Counter(text)
        cntBalloon = collections.Counter("balloon")
        return min([cnt[c] // cntBalloon[c] for c in cntBalloon])
