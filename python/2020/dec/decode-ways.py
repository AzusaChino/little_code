class Solution:
    def numDecodings(self, s: str) -> int:
        if not s:
            return 0
        nb_ways = [0] * (len(s) +1)
        nb_ways[0] = 1
        if s[0] != '0':
            nb_ways[1] = 1
        for i in range(1, len(s)):
            if s[i] != '0':
                nb_ways[i+1] += nb_ways[i]
            if 10 <= int(s[i-1:i+1]) <= 26:
                nb_ways[i+1] += nb_ways[i-1]
        return nb_ways[-1]

