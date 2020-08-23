package cn.az.code.other.array;

/**
 * @author az
 * @since 08/22/20
 */
public class ThreeConsecutiveOdds {

    public static void main(String[] args) {
        ThreeConsecutiveOdds tc = new ThreeConsecutiveOdds();
        System.out.println(tc.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int odds = 0;
        for (int i = 0; i < arr.length && odds < 3; i++) {
            // 遇到非奇数 => 重置为0
            odds = (arr[i] & 1) == 1 ? ++odds : 0;
            if (odds == 3) {
                return true;
            }
        }
        return false;
    }
}
