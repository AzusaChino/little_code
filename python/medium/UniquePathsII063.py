def uniquePathsWithObstacles(obstacle_grid):
    if not obstacle_grid:
        return
    r, c = len(obstacle_grid), len(obstacle_grid[0])
    obstacle_grid[0][0] = 1 - obstacle_grid[0][0]
    for i in range(1, r):
        obstacle_grid[i][0] = obstacle_grid[i - 1][0] * (1 - obstacle_grid[i][0])
    for i in range(1, c):
        obstacle_grid[0][i] = obstacle_grid[0][i - 1] * (1 - obstacle_grid[0][i])
    for i in range(1, r):
        for j in range(1, c):
            obstacle_grid[i][j] = (obstacle_grid[i - 1][j] + obstacle_grid[i][j - 1]) * (1 - obstacle_grid[i][j])
    return obstacle_grid[-1][-1]


