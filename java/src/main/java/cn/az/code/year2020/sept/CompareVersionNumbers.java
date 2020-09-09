package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 09/09/20
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers cv = new CompareVersionNumbers();
        System.out.println(cv.compareVersion("1.0", "1.0.0"));
        System.out.println(cv.compareVersion("1.0.1", "1.0"));
        System.out.println(cv.compareVersion("7.5.2.4", "7.5.3"));
    }

    public int compareVersion(String version1, String version2) {
        int[] v1 = toInt(version1);
        int[] v2 = toInt(version2);
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            if (i < v1.length && i < v2.length) {
                if (v1[i] > v2[i]) {
                    return 1;
                } else if (v1[i] < v2[i]) {
                    return -1;
                }
            } else if (i >= v1.length) {
                if (v2[i] > 0) {
                    return -1;
                }
            } else {
                if (v1[i] > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private int[] toInt(String v) {
        String[] strings = v.split("\\.");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }
}
