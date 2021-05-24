package cn.az.code.year2021.may;

/**
 * @author az
 * @since 2021-05-24
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (char) (str.charAt(i) | (char) (32));
            sb.append(c);
        }
        return sb.toString();
    }

    public String _toLowerCase(String str) {
        char[] res = str.toCharArray();
        for (int i = 0; i < res.length; i++)
            if (res[i] >= 'A' && res[i] <= 'Z')
                res[i] += 32;
        return new String(res);
    }
}