class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        oribin = '{0:032b}'.format(n)
        reversebin = oribin[::-1]
        return int(reversebin, 2)

    def _reverseBits(self, n):
        res = 0
        for _ in range(32):
            res = (res << 1) + (n & 1)
            n >>= 1
        return res

    def __reverseBits(self, n):
        return int(bin(n)[2:].zfill(32)[::-1], 2)
