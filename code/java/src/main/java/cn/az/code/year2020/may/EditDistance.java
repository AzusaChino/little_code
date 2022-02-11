package cn.az.code.year2020.may;

public class EditDistance {

    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {

        if (isNotBlank(word1) && isNotBlank(word2)) {
            return 0;
        }
        if (isNotBlank(word1)) {
            return word2.length();
        }
        if (isNotBlank(word2)) {
            return word1.length();
        }
        if (word1.toCharArray()[0] == word2.toCharArray()[0]) {
            return minDistance(word1.substring(1), word2.substring(1));
        }
        int insert = 1 + minDistance(word1, word2.substring(1));
        int delete = 1 + minDistance(word1.substring(1), word2);
        int replace = 1 + minDistance(word1.substring(1), word2.substring(1));
        return Math.min(Math.min(insert, delete), replace);
    }

    private boolean isNotBlank(String s) {
        return s != null && s.length() > 0;
    }
}
