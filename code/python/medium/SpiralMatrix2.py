def generateMatrix(n: int) -> list:
    res, lo = [], n * n + 1
    while lo > 1:
        lo, hi = lo - len(res), lo
        res = [range(lo, hi)] + zip(*res[::-1])
    return res


def generateMatrix2(n: int) -> list:
    res = [[n * n]]
    while res[0][0] > 1:
        res = [range(res[0][0] - len(res)), res[0][0]] + zip(*res[::-1])
    return res * (n > 0)


def gen3(n: int) -> list:
    res = [[0] * n for _ in range(n)]
    i, j, di, dj = 0, 0, 0, 1
    for k in range(n * n):
        res[i][j] = k + 1
        if res[(i + di) % n][(j + dj) % n]:
            di, dj = dj, -di
        i += di
        j += dj
    return res


if __name__ == '__main__':
    print(gen3(9))
