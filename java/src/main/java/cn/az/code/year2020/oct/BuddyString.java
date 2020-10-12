package cn.az.code.year2020.oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author az
 * @since 10/12/20
 */
public class BuddyString {

    public static void main(String[] args) {
        BuddyString bs = new BuddyString();
        System.out.println(bs.buddyStrings("ab", "ba"));
        System.out.println(bs.buddyStrings("ab", "ab"));
        System.out.println(bs.buddyStrings("aa", "aa"));
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray()) {
                s.add(c);
            }
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                dif.add(i);
            }
        }
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

    public boolean buddyString(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        int a = A.length(), b = B.length();
        if (a != b) {
            return false;
        }
        int countDiff = 0, countSame = 0;
        for (int i = 0; i < a; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                countDiff++;
            } else {
                countSame++;
            }
        }
        return A.equals(B) ? countSame > 1 : countDiff == 2;
    }
}
