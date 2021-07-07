package cn.az.code.year2021.july;

/**
 * @author az
 * @since 2021-07-07
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        // num of rows and cols in matrix
        int rows = matrix.length, cols = matrix[0].length;
        // get the lowest and highest possible num, will shrink search space according
        // to the two nums
        // [lo, hi] is our initial search range
        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, maxNum = lo;
            // for each row, we r going to find # of nums < mid in that row
            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid)
                    c--; // this row's c has to be smaller than the c found in last row due to the sorted
                         // property of the matrix
                if (c >= 0) {
                    count += (c + 1); // count of nums <= mid in matrix
                    maxNum = Math.max(maxNum, matrix[r][c]); // mid might be value not in matrix, we need to record the
                                                             // actually max num;
                }
            }
            // adjust search range
            if (count == k)
                return maxNum;
            else if (count < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        // 1) Q: Why we return lo at the end:
        // A: Here lo=hi+1, for hi, we found <k elems, for lo, we found >=k elem, lo
        // must have duplicates in matrix, return lo
        // 2) Q: Why lo exist in the matrix
        // A: for lo which is only 1 more than hi, we could find some extra nums in
        // matrix so that there are >=k elems, so lo it self must exist in the matrix to
        // meet the requirement. please check the illustration at the beginning of the
        // post
        return lo;
    }
}
