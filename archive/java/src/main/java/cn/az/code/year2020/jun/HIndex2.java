package cn.az.code.year2020.jun;

/**
 * @author az
 * @since 2020-06-18 21:29
 */
public class HIndex2 {

    public int hIndex(int[] citations) {
        int l = 0, len = citations.length, r = len - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (citations[mid] >= (len - mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return len - l;
    }
}
