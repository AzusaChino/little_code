package cn.az.code.medium;

/**
 * @author az
 * @date 2020/4/14
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        
    }
    // Method1()- recursive solution(Top- down approach)
    // time complexity - O(2^(m+n))
    // space complexity - O(m+n)

    public static int lcm1(char[] x, char[] y, int i, int j) {
        if (i <= 0 || j <= 0) {
            return 0;
        }
        if (x[i - 1] == y[j - 1]) {
            return 1 + lcm1(x, y, i - 1, j - 1);
        } else {
            return Math.max(lcm1(x, y, i, j - 1), lcm1(x, y, i - 1, j));
        }

    }

    // Method2()- recursive solution with memoization
    // time complexity - O(m*n)
    // space complexity - O(m*n)

    public static int lcm2(char[] x, char[] y, int i, int j, Integer[][] dp) {
        if (i <= 0 || j <= 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (x[i - 1] == y[j - 1]) {
            return 1 + lcm2(x, y, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(lcm2(x, y, i, j - 1, dp), lcm2(x, y, i - 1, j, dp));
        }

    }

    // Method3()- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(m*n)

    public static int lcm3(char[] x, char[] y, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[m][n];
    }

    // Method4()- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(n)

    public static int lcm4(char[] x, char[] y, int m, int n) {
        int[] memo = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (x[i - 1] == y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }

        }
        return memo[n];
    }
}
