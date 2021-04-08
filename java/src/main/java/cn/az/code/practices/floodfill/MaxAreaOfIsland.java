package cn.az.code.practices.floodfill;

/**
 * @author az
 * @date 5/13/2020
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, helper(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int helper(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + helper(grid, i+1, j) + helper(grid, i-1, j) + helper(grid, i, j-1) + helper(grid, i, j+1);
        }
        return 0;
    }

    public int island(int[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    sink(grid, i, j, m, n);
                }
            }
        }
        return result;
    }

    private void sink(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sink(grid, i + 1, j, m, n);
        sink(grid, i - 1, j, m, n);
        sink(grid, i, j + 1, m, n);
        sink(grid, i, j - 1, m, n);
    }

}
