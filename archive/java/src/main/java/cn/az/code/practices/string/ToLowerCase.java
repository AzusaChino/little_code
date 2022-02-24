package cn.az.code.practices.string;

/**
 * @author az
 * @since 2020-06-18 22:07
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            char c = (char) (ch | 32);
            sb.append(c);
        }
        return sb.toString();
    }
}
