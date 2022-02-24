package cn.az.code.medium;

/**
 * @author az
 * @since 2020-04-15
 */
public class Triangle {

    public static void main(String[] args) {
        int[][] t = new int[4][];
        t[0] = new int[]{1};
        t[1] = new int[]{1, 5, 6};
        t[2] = new int[]{10, 8, 9, 2};
        t[3] = new int[]{99, 4, 5, 76, 8, 1};
        System.out.println(search(t));
    }

    /**
     * DP: dp[i,j] = g[i,j] + min(g[i+1,j], g[i+1,j+1]
     *
     * @param tri triangle
     * @return minimum
     */
    public static int search(int[][] tri) {
        int height = tri.length;
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < tri[i].length; j++) {
                tri[i][j] += Math.min(tri[i + 1][j], tri[i + 1][j + 1]);
            }
        }
        return tri[0][0];
    }
}
