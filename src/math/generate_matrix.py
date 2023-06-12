from typing import List


def generate_rotate_array(n: int) -> List[int]:
    matrix = [[0 for _ in range(n)] for _ in range(n)]
    x, y = 0, 0
    loop = mid = n // 2
    count = 1
    for offset in range(1, loop + 1):
        for i in range(y, n - offset):
            matrix[x][i] = count
            count += 1
        for i in range(x, n - offset):
            matrix[i][n - offset] = count
            count += 1
        for i in range(n - offset, y, -1):
            matrix[n - offset][i] = count
            count += 1
        for i in range(n - offset, x, -1):
            matrix[i][y] = count
            count += 1
        x += 1
        y += 1
    if n % 2 != 0:
        matrix[mid][mid] = count
    return matrix

print(generate_rotate_array(3))