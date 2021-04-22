package cn.az.code.year2021.apr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021-04-22 15:37
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (List<Integer> list : wall) {
            int sum = 0;
            // not allowed to pass edge
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                count = Math.max(count, map.get(sum));
            }
        }
        return wall.size() - count;
    }

}
