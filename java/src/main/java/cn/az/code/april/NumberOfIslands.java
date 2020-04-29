package cn.az.code.april;

/**
 * @author az
 * @date 2020/4/29
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands ni = new NumberOfIslands();
    }

    private int m, n;

    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        // iterate all positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sink(grid, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    public void sink(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        // sink four directions
        sink(grid, i + 1, j);
        sink(grid, i - 1, j);
        sink(grid, i, j+1);
        sink(grid, i, j-1);
    }
}
