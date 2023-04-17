def sqrt(n) -> int:
    r = n
    while r * r > n:
        r = (r + n / r) / 2
    return r


if __name__ == "__main__":
    print(sqrt(4))
    print(sqrt(999999999))
