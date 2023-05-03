class Solution:
    def check(self, s: str) -> bool:
        p = 0
        for c in s:
            if c == "(":
                p += 1
            if c == ")":
                p -= 1
            if p < 0:
                return False
        return p == 0

    def checkValidString(self, s: str) -> bool:
        """
        cmax counts the maximum open parenthesis,
        which means the maximum number of unbalanced '(' that COULD be paired.
        cmin counts the minimum open parenthesis,
        which means the number of unbalanced '(' that MUST be paired.
        """
        cmin = cmax = 0
        for c in s:
            if c == "(":
                cmax += 1
                cmin += 1
            if c == ")":
                cmax -= 1
                cmin -= 1
            if c == "*":
                cmax += 1  # if `*` become `(` then openCount++
                cmin -= 1  # if `*` become `)` then openCount--
            if cmax < 0:
                return False
            cmin = max(cmin, 0)
        return cmin == 0

if __name__ == "__main__":
    s = Solution()
    print(s.check(")(((())))"))