package cn.az.code.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liz
 * @version 2019/11/28
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(sum(new int[]{-1,0,1,2,-1,-4},-1));
    }

    public static List<List<Integer>> sum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return res;
        }
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while(l<r) {
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if (sum > target) {
                        r--;
                    } else if(sum < target) {
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
