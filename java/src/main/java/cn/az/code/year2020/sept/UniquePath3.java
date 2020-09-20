package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 09/20/20
 */
public class UniquePath3 {

    int res = 0, empty = 1, sx, sy, ex, ey;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 计算所有0
                if (grid[i][j] == 0) {
                    empty++;
                    // 找到1
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                    // 找到2
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }
        if (grid[x][y] == 2) {
            if (empty == 0) {
                res++;
            }
            return;
        }
        grid[x][y] = -2;
        empty--;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        grid[x][y] = 0;
        empty++;
    }
}
