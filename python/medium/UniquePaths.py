from functools import reduce


def unique_path(m, n) -> int:
    if 1 in [m, n]:
        return 1
    return reduce(lambda x, y: x * y, range(n, n + m - 1)) / reduce(lambda x, y: x * y, range(1, m))


if __name__ == '__main__':
    print(unique_path(7, 3))
