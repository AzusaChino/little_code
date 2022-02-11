package cn.az.code.year2020.may;

/**
 * @author az
 * @date 5/3/2020
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public boolean isBadVersion(int n) {
        return true;
    }
}
