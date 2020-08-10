from functools import reduce


def to_number(s: str) -> int:
    return reduce(lambda x, y: 26 * x + y, [ord(c) - 64 for c in list(s)])
