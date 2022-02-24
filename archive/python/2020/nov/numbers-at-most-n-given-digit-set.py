class Solution:
    def atMostNGivenDigitSet(self, digits, n):
        n = str(n)

        nLen = len(n)
        res = sum(len(digits) ** i for i in range(1, nLen))
        i = 0
        while i < len(n):
            res += sum(c < n[i] for c in digits) * (len(digits) ** (nLen - i - 1))
            if n[i] not in digits: break
            i += 1
        return res + (i == nLen)
