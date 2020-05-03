package cn.az.code.may;

/**
 * @author az
 * @date 5/3/2020
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] notes = ransomNote.toCharArray(), magazines = magazine.toCharArray();
        int find = 0;
        for (char c : notes) {
            int count = 0;
            for (int i = 0; i < magazines.length; i++) {
                if (magazines[i] == c) {
                    magazines[i] = '0';
                    find++;
                    break;
                } else {
                    if (count == magazines.length) {
                        return false;
                    }
                    count++;
                }
            }
        }
        return find == notes.length;
    }
}
