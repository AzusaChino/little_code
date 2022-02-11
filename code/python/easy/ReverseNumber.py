def reverse(num):
    ret = 0
    if num > 0:
        flag = 1
    else:
        flag = -1
    n = abs(num)
    while n != 0:
        ret = ret * 10 + n % 10
        n //= 10
        if ret > 2 ** 31 - 1 or ret < -2 ** 31:
            return 0
    return ret*flag


if __name__ == '__main__':
    print(reverse(-998))
