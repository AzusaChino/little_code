package cn.az.code.year2020.july;

/**
 * @author az
 * @since 2020-07-07 22:41
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    public int _islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        // four direction
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int __islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return helper(grid, dir, i, j);
                }
            }
        }
        return 0;
    }

    int helper(int[][] grid, int[][] dir, int i, int j) {

        int m = grid.length, n = grid[0].length;
        grid[i][j] = -1;
        int count = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) {
                count++;
            } else {
                if (grid[x][y] == 1) {
                    count += helper(grid, dir, x, y);
                }
            }
        }
        return count;
    }
}
