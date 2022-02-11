package cn.az.code.year2021.jan;

/**
 * @author az
 * @since 01/17/21 17:01
 */
public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
//                a  e  i  o  u
//     initially: {1, 1, 1, 1, 1}
//      n == 1 : {5, 4, 3, 2, 1}
//      n == 2 : {15,10,6, 3, 1}
//      n == 3 : {35,20,10,4, 1}
//
        int[] permutation = {1, 1, 1, 1, 1};

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = permutation.length - 1; j >= 0; j--) {
                permutation[j] = permutation[j] + sum;
                sum = permutation[j];
            }
        }

        return permutation[0];
    }

    public int _countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k <= 5; ++k) {
                dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
            }
        }
        return dp[n][5];
    }

    public int __countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }

}
