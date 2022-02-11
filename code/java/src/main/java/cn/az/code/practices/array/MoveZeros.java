package cn.az.code.practices.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 10/12/20
 */
public class MoveZeros {

    public void move1(int[] nums) {
        int n = nums.length;
        int numZeros = 0;
        for (int num : nums) {
            if (num == 0) {
                numZeros++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }
        while (numZeros > 0) {
            list.add(0);
            numZeros--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }

    }

    public void moveZeros(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
