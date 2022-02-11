class Solution:
    def add_digits(self, num):
        if num == 0:
            return 0
        else:
            return (num - 1) % 9 + 1


def add_digits(num):
    while num >= 10:
        tmp = 0
        while num > 0:
            tmp += num%10
            num //=10
        num = tmp
    return num
