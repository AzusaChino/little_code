from typing import List


class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        """
        因为 n & (n - 1) 可以消除最后一个 1
        所以可以用一个循环不停地消除 1 同时计数，直到 n 变成 0 为止。
        """
        dist = 0
        n = x ^ y
        while n:
            dist += 1
            n &= n - 1
        return dist

    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        return (n & (n - 1)) == 0

    def singleNumber(self, nums: List[int]) -> int:
        """
        一个数和它本身做异或运算结果为 0, 即 a ^ a = 0
        一个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a。
        """
        a = 0
        for n in nums:
            a ^= n
        return a

    def missingNumber(self, nums: List[int]) -> int:
        """
        等差数列求和公式: （首项+末项）× 项数 / 2
        """
        n = len(nums)
        a = (0 + n) * (n + 1) // 2
        b = sum(nums)
        return a - b

    def missingNumber1(nums: List[int]) -> int:
        """
        只要把所有的元素和索引做异或运算，成对儿的数字都会消为 0
        只有这个落单的元素会剩下
        2 ^ 3 ^ 2 = 3 ^ (2 ^ 2) = 3 ^ 0 = 3
        """
        n = len(nums)
        res = 0
        # 先和新补的索引异或一下
        res ^= n
        # 和其他的元素、索引做异或
        for i in range(n):
            res ^= i ^ nums[i]
        return res
