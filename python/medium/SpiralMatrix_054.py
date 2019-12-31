def spiralOrder(matrix) -> list:
    return matrix and [*matrix.pop(0)] + spiralOrder([*zip(*matrix)][::-1])


if __name__ == '__main__':
    l = [[1, 2, 3], [4, 5, 6]]
    print(spiralOrder(l))
    print([*zip(*l)][::-1])
