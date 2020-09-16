package cn.az.code.other.untag;

/**
 * @author az
 * @since 09/16/20
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("aab", "c*a*b"));
        System.out.println("aab".matches("c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return true;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatchRecursive(String s, String p) {
        return isMatch(0, 0, s, p);
    }

    private boolean isMatch(int i, int j, String s, String p) {
        int sn = s.length(), pn = p.length();
        if (j == pn) {
            return i == sn;
        }
        if (j + 1 < pn && p.charAt(j + 1) == '*') {
            if (isMatch(i, j + 2, s, p)) {
                return true;
            }
            while (i < sn && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                if (isMatch(++i, j + 2, s, p)) {
                    return true;
                }
            }
        } else if (i < sn && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            return isMatch(i + 1, j + 1, s, p);
        }
        return false;
    }

    public boolean isMatchWrong(String s, String p) {
        if (s == null || p == null || s.isEmpty() || p.isEmpty()) {
            return true;
        }
        String[] xs = s.split("");
        String[] ys = p.split("\\*");
        int left = 0;
        for (String y : ys) {
            if (".".equals(y)) {
                left = xs.length - 1;
            } else {
                if (xs[left].equals(y)) {
                    while (xs[left].equals(y)) {
                        left++;
                    }
                }
            }
        }
        return left == s.length() - 1;
    }
}
