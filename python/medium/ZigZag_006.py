def convert(s: str, n: int) -> str:
    if n == 1 or n >= len(s):
        return s

    line = [''] * n
    index, step = 0, 1

    for x in s:
        line[index] += x
        if index == 0:
            step = 1
        elif index == n - 1:
            step = -1
        index += step

    return ''.join(line)


if __name__ == '__main__':
    print(convert('PAYPALISHIRING', 3))
