package cn.az.code.year2021.sept;

/**
 * @author az
 * @since 2021-9-15
 */
public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        int res = 0;
        for (int i = 0, cnt = 0; i + 1 < arr.length; ++i, cnt *= -1) {
            if (arr[i] > arr[i + 1]) cnt = cnt > 0 ? cnt + 1 : 1; else if (
                arr[i] < arr[i + 1]
            ) cnt = cnt < 0 ? cnt - 1 : -1; else cnt = 0;
            res = Math.max(res, Math.abs(cnt));
        }
        return res + 1;
    }
}
