package cn.az.code.other.untag;

/**
 * little-code
 *
 * @author azusachino
 * @since 22/9/2020 21:11
 */
public class MajorityElement {

    public int majority(int[] nums) {
        // for one majority
        int major = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                major = num;
            } else if (major == num) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
