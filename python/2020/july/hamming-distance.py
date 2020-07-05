class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        xor = x ^ y
        count = 0
        for _ in range(32):
            count += xor & 1
            xor = xor >> 1
        return count

    def hamming_distance(self, x, y):
        return sum(((x ^ y) >> n) & 1 != 0 for n in range(32))


class TotalHammingDistance:
    def totalHammingDistance(self, nums):
        return sum(b.count('0') * b.count('1') for b in zip(*map('{:032b}'.format, nums)))
