from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        N = len(s)
        d = {}
        for i in range(N - 9):
            cur = s[i : i + 10]
            if cur not in d:
                d[cur] = 1
            else:
                d[cur] += 1
        ret = []
        for ss, c in d.items():
            if c > 1:
                ret.append(ss)
        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.findRepeatedDnaSequences("AAAAAAAAAAA"))
    a = "\tabcd.abc"
    print(a)
    print(a.count("."))
