def arrange_coins(n: int) -> int:
    if n == 1:
        return 1
    i = 1
    while i <= n:
        n -= i
        i += 1
    return i - 1
