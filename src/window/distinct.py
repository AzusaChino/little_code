class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r = 0, 0
        d = {}
        ret = 0
        while r < len(s):
            rc = s[r]
            r += 1
            if rc in d:
                d[rc] += 1
            else:
                d[rc] = 1
            while d[rc] > 1:
                lc = s[l]
                l += 1
                if lc in d:
                    d[lc] -= 1
            ret = max(ret, r - l)
        return ret


if __name__ == "__main__":
    s = Solution()
    print(s.lengthOfLongestSubstring("abcabc"))
    print(s.lengthOfLongestSubstring("bbbbb"))
