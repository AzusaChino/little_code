class Solution:
    my_pow = pow

    def pow1(self, x, n):
        return x ** n

    def pow2(self, x, n):
        if not n:
            return 1
        if n < 0:
            return 1 / self.pow2(x, -n)
        if n % 2:
            return x * self.pow2(x, n - 1)
        return self.pow2(x * x, n / 2)

    def pow3(self, x, n):
        if n < 0:
            x = 1 / x
            n = -n
        pow = 1
        while n:
            if n & 1:
                pow *= x
            x *= x
            n >>= 1
        return pow
