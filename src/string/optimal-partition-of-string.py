class Solution:
    def partitionString(self, s: str) -> int:
        ret = 0
        cur = set()
        for ch in s:
            if ch in cur:
                ret += 1
                cur.clear()
            cur.add(ch)
        if cur:
            ret += 1
        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.partitionString("abacaba"))
