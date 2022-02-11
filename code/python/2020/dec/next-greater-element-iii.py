class Solution:
    def nextGreaterElement(self, n):
        num = [c for c in str(n)]
        i = len(num) - 1
        while i > 0 and num[i - 1] >= num[i]:
            i -= 1
        if i == 0:
            return -1
        j = i
        while j + 1 < len(num) and num[j + 1] > num[i - 1]:
            j += 1
        num[j], num[i - 1] = num[i - 1], num[j]
        result = int("".join(num[:i] + sorted(num[i:])))
        return -1 if result >= 2 ** 31 else result
