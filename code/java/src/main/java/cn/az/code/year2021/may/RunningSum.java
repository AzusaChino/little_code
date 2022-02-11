package cn.az.code.year2021.may;

import java.util.List;
import java.util.ArrayList;

/**
 * @author az
 * @since 2021-05-03
 */
public class RunningSum {

    public List<Integer> runningSum(List<Integer> nums) {
        List<Integer> list = new ArrayList<>(nums.size()+1);
        list.set(0, 0);
        for (int i = 1; i < nums.size(); i++) {
            list.set(i, list.get(i-1) + nums.get(i-1));
        }
        
        return list.subList(1, nums.size());
    }
}