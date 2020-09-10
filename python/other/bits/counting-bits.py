def count_bits(n):
    bits = [0 for _ in range(n + 1)]
    for i in range(1, n + 1):
        bits[i] += bits[i & (i - 1)] + 1
    return bits


if __name__ == '__main__':
    print(count_bits(9))
