package cn.az.code.year2020.jun;

import java.util.*;

/**
 * @author az
 * @since 2020-06-12 22:54
 */
public class RandomizedSet {

    public static final Random RANDOM = new Random();

    private List<Integer> nums;
    private Map<Integer, Integer> locs;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
            return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
            return false;
        }
        int loc = locs.get(val);
        // not the last one than swap the last one with this val
        if (loc < nums.size() - 1) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(RANDOM.nextInt(nums.size()));
    }
}
