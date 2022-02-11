from functools import reduce
from itertools import combinations


def combine1(n, k):
    return list(combinations(range(1, n + 1), k))


def combine2(n, k):
    if k == 0:
        return [[]]
    return [pre + [i] for i in range(k, n + 1) for pre in combine2(i - 1, k - 1)]


def combine3(n, k):
    combs = [[]]
    for _ in range(k):
        combs = [[i] + c for c in combs for i in range(1, c[0] if c else n + 1)]
    return combs


def combine4(n, k):
    return reduce(lambda C, _: [[i] + c for c in C for i in range(1, c[0] if c else n + 1)], range(k), [[]])


if __name__ == '__main__':
    print(combine4(4,2))
