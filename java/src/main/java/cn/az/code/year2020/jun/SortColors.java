package cn.az.code.year2020.jun;

/**
 * @author az
 * @since 2020-06-12 07:56
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;
        int temp;
        while(white <= blue) {
            if (nums[white] == 0) {
                temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                white++;
                red++;
            } else if (nums[white] == 1) {
                white++;
            } else {
                temp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = temp;
                blue--;
            }
        }
    }
}
