package cn.az.code.medium;

/**
 * @author azusachino
 */
public class WaterContainer {

    public static void main(String[] args) {
        // O(n^2) 一维数组的坐标变化
        WaterContainer waterContainer = new WaterContainer();
        System.out.println(find(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(waterContainer.solution(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private int solution(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = heights.length-1; j >i ; j--) {
                res = Math.max(res, (j-1)*Math.min(heights[i],heights[j]));
            }
        }
        return res;
    }
    private static int find(int[] heights) {
        // O(n) 左右边界, 同时向中间收敛
        int l =0,r = heights.length -1;
        int res = 0, h;
        while (l < r) {
            h = Math.min(heights[l], heights[r]);
            res = Math.max(res, (r-l) * h);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
