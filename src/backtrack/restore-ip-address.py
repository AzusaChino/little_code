from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:

        ret = []
        track = []

        def backtrack(s, start, track: List[str]):
            if len(track) > 4:
                return
            if start == len(s) and len(track) == 4:
                ret.append(".".join(track))
            for i in range(start, len(s)):
                cur = s[start : i + 1]
                if not isV4(cur):
                    continue
                track.append(cur)
                backtrack(s, i + 1, track)
                track.pop()

        def isV4(s):
            try:
                return str(int(s)) == s and 0 <= int(s) <= 255
            except:
                return False

        backtrack(s, 0, track)
        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.restoreIpAddresses("25525511135"))
