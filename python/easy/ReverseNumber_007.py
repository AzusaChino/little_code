def reverse(num):
    ret = 0
    while num != 0:
        ret = ret * 10 + num % 10
        num //= 10
        if ret > 2 ** 31 - 1 or ret < -2 ** 31:
            return 0
    return ret


if __name__ == '__main__':
    print(reverse(998))
