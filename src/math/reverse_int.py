def reverse(x: int) -> int:
    n = [1, -1][x < 0] * int(str(abs(x))[::-1])
    return n if n.bit_length() < 32 else 0
