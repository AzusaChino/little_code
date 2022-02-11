package cn.az.code.practices.array;

/**
 * @author az
 * @since 10/20/20
 */
public class SumOfAllOddLengthSubarray {

    public static void main(String[] args) {
        SumOfAllOddLengthSubarray s = new SumOfAllOddLengthSubarray();
        System.out.println(s.sumOddLengthSubarrays(new int[]{1, 2, 3}));
    }

    public int sumOddLengthSubarrays(int[] A) {
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * A[i];
        }
        return res;
    }

    public int sumOddLengthSubarrays_(int[] arr) {
        int ans = 0, n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; j += 2) {
                ans += prefixSum[j] - prefixSum[i];
            }
        }
        return ans;
    }

    public int sumOddLengthSubArrays(int[] arr) {
        int ret = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cur = (int) Math.ceil((i + 1) * (n - i) / 2);
            ret += cur * arr[i];
        }
        return ret;

    }
}
