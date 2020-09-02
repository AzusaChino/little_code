package cn.az.code.year2020.sept;

import java.util.*;

/**
 * @author az
 * @since 09/02/20
 */
public class ContainDuplicate3 {

    public static void main(String[] args) {
        ContainDuplicate3 duplicate3 = new ContainDuplicate3();
        ContainDuplicate2 duplicate2 = new ContainDuplicate2();
        System.out.println(duplicate3.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(duplicate3.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
        System.out.println(duplicate3.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(duplicate3.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
//        System.out.println(duplicate2.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private long getId(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long min = set.ceiling((long)nums[i] - t);    // minimum candidate in the target range [nums[i] - t, nums[i] + t]
            if (min != null && min <= (long)nums[i] + t) {
                return true;    // found duplicates
            }
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getId(nums[i], w);
            if (d.containsKey(m)) {
                return true;
            }
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w) {
                return true;
            }
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w) {
                return true;
            }
            d.put(m, (long)nums[i]);
            if (i >= k) {
                d.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    // 性能极差
    public boolean myContainsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                if ((i + j) >= len) {
                    break;
                }
                if (Math.abs((long)nums[i] - (long)nums[i + j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    static final class ContainDuplicate {

        public boolean containsDuplicateOldFashion(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i : nums) {
                if (!set.add(i))// if there is same
                {
                    return true;
                }
            }
            return false;
        }

        public boolean containsDuplicate(int[] nums) {
            return Arrays.stream(nums).distinct().count() < nums.length;
        }
    }

    static final class ContainDuplicate2 {

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = 1; j <= k; j++) {
                    if ((i + j) >= len) {
                        break;
                    }
                    if (nums[i] == nums[i + j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
