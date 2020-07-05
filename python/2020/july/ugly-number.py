import heapq
import itertools
from typing import List


def is_ugly_number(num: int) -> bool:
    for p in 2, 3, 5:
        while num % p == 0 < num:
            num /= p
    return num == 1


def super_ugly_number(n: int, primes: List[int]) -> int:
    uglies = [1]

    def generate(prime):
        for u in uglies:
            yield u * prime

    merged = heapq.merge(*map(generate, primes))
    while len(uglies) < n:
        ugly = next(merged)
        if ugly != uglies[-1]:
            uglies.append(ugly)
        return uglies[-1]


def nthSuperUglyNumber(n, primes):
    uglies = [1]
    merged = heapq.merge(*map(lambda p: (u * p for u in uglies), primes))
    unique = (u for u, _ in itertools.groupby(merged))
    map(uglies.append, itertools.islice(unique, n - 1))
    return uglies[-1]


if __name__ == '__main__':
    print(nthSuperUglyNumber(12, [2, 7, 13, 19]))
