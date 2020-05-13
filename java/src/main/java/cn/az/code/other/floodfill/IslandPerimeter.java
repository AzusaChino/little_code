package cn.az.code.other.floodfill;

/**
 * @author az
 * @date 5/13/2020
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();
        int[][] grid = new int[4][4];
        grid[0] = new int[]{0, 1, 0, 0};
        grid[1] = new int[]{1, 1, 1, 0};
        grid[2] = new int[]{0, 1, 0, 0};
        grid[3] = new int[]{1, 1, 0, 0};
        System.out.println(ip.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbours++; // count down neighbours
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        neighbours++; // count right neighbours
                    }
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    int res = 0;

    public int islandPerimeter2(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        boolean[][] b = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, n, m, b);
                    return res;
                }
            }
        }
        return 0;
    }

    void dfs(int[][] grid, int x, int y, int n, int m, boolean[][] b) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            res++;
            return;
        }
        if (b[x][y]) {
            return;
        }
        b[x][y] = true;
        dfs(grid, x, y + 1, n, m, b);
        dfs(grid, x, y - 1, n, m, b);
        dfs(grid, x - 1, y, n, m, b);
        dfs(grid, x + 1, y, n, m, b);
    }
}
