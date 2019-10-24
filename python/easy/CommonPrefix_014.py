class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if 0 is len(strs):
            return ''
        prefix = strs[0]
        i = len(prefix)
        while i > 0:
            count = 0
            for string in strs:
                if prefix[0:i] == string[0:i]:
                    count += 1
                else:
                    i -= 1
            if count == len(strs):
                return prefix[0:i]
        return ''

if __name__ == "__main__":
    s = Solution()
    print(s.longestCommonPrefix(['haha','hehe','hello']))