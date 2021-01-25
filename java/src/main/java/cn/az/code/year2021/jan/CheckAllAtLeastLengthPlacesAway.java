package cn.az.code.year2021.jan;

/**
 * @author ycpang
 * @since 2021-01-25 16:14
 */
public class CheckAllAtLeastLengthPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != 0 && i - prev < k + 1) {
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}
