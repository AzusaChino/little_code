package cn.az.code.year2021.sept;

/**
 * @author az
 * @since 2021-9-1
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int res = 0, n = nums.length;
        boolean[] seen = new boolean[n];
        for (int i : nums) {
            int cnt = 0;
            while (!seen[i]) {
                seen[i] = true;
                cnt++;
                i = nums[i];
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
