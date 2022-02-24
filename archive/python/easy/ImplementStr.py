class Solution:
    def failure(self, patt):
        lps = [0 for _ in range(len(patt))]
        itr = 0
        i = 1
        while i < len(patt):
            if patt[i] == patt[itr]:
                itr += 1
                lps[i] = itr
                i += 1
            else:
                if itr != 0:
                    itr = lps[itr - 1]
                else:
                    itr = lps[itr - 1]
                    i += 1
        return lps

    def kmp(self, string, pattern):
        lps = self.failure(pattern)
        print(lps)
        i = 0
        j = 0
        while i < len(string):
            if pattern[j] == string[i]:
                if j == len(pattern) - 1:
                    # print("Found pattern at: " + str(i))
                    print(i, j)
                    return i - j
                i += 1
                j += 1
            elif j > 0:
                j = lps[j - 1]
            else:
                i += 1
        return -1

    def str_str(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        return self.kmp(haystack, needle)
