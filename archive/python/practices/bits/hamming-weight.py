class Solution:
    def hammingWeight(self, n):
        ret = 0
        mask = 1
        for i in range(32):
            if n & mask:
                ret += 1
            mask = mask << 1
        return ret

    def hamming_weight(self, n):
        ret = 0
        while n:
            ret += 1
            n = n & (n - 1)
        return ret
