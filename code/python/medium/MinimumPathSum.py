def minimum(grid):
    if not grid:
        return
    m, n = len(grid), len(grid[0])
    for i in range(1, m):
        grid[i][0] += grid[i - 1][0]
    for i in range(1, n):
        grid[0][i] += grid[0][i - 1]
    for i in range(1, m):
        for j in range(1, n):
            grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
    return grid[-1][-1]


if __name__ == '__main__':
    grid = [[1, 2, 3], [3, 2, 1], [5, 5, 6], [1, 2, 5]]
    print(minimum(grid))
