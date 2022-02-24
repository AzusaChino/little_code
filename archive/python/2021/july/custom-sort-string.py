from typing import Collection


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        ans, cnt = [], Collection.Counter(T)  # count each char in T.
        for c in S:
            if cnt[c]:
                ans.extend(
                    c * cnt.pop(c)
                )  # sort chars both in T and S by the order of S.
        for c, v in cnt.items():
            ans.extend(c * v)  # group chars in T but not in S.
        return "".join(ans)
