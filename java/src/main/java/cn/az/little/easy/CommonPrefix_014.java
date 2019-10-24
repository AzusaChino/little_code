package cn.az.little.easy;

/**
 * @author : Liz
 * @date : 2019/10/24
 **/
public class CommonPrefix_014 {
    public static void main(String[] args) {

        System.out.println(find(new String[]{"dog", "dracecar", "dcar"}));
    }

    public static String find(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // indexOf return -1 if dont contain, 0 means this string starts with this 'prefix'
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }
}
