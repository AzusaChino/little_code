package cn.az.code.year2020.oct;

/**
 * @author az
 * @since 10/23/20
 */
public class Pattern132 {

    public static void main(String[] args) {
        Pattern132 pattern132 = new Pattern132();
        int[] nums = {-2, 1, -2};
        System.out.println(pattern132.find132pattern(nums));
    }

    public boolean find132pattern_(int[] nums) {
        int two = Integer.MIN_VALUE;
        int index = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < two) {
                return true;
            }
            while (index < nums.length && nums[i] > nums[index]) {
                two = nums[index++];
            }
            nums[--index] = nums[i];
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[i] < nums[l] && nums[r] > nums[i] && nums[l] > nums[r]) {
                    return true;
                }
                if (nums[i] > nums[l] || nums[i] > nums[r]) {
                    l++;
                }
                if (nums[l] < nums[r]) {
                    r--;
                }
            }
        }
        return false;
    }
}
