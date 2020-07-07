package cn.az.code.other.array;

/**
 * @author az
 * @since 2020-07-07 07:35
 */
public class ContainerWithMostWater {


    public static int maxArea1(int[] height) {
        int max = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    public static int most(int[] container) {
        int l = 0, r = container.length - 1;
        int ret = 0;
        while (l < r) {
            ret = Math.max(ret, (r - l) * Math.min(container[l], container[r]));
            if (container[l] > container[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ret;
    }
}
