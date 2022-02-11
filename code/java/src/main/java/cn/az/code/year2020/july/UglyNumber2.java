package cn.az.code.year2020.july;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author az
 * @since 2020-07-05 08:39
 */
public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    static class UglyNumber {
        public boolean isUgly(int num) {
            for (int i = 2; i < 6 && num > 0; i++) {
                while (num % i == 0) {
                    num /= i;
                }
            }
            return num == 1;
        }

        public static boolean _isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            while (num % 2 == 0) {
                num /= 2;
            }
            while (num % 3 == 0) {
                num /= 3;
            }
            while (num % 5 == 0) {
                num /= 5;
            }
            return num == 1;
        }
    }

    static class UglyNumber3 {
        int MAX_ANS = (int) 2e9; // 2*10^9

        public int nthUglyNumber(int n, int a, int b, int c) {
            int left = 0, right = MAX_ANS, result = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (count(mid, a, b, c) >= n) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return result;
        }

        int count(long num, long a, long b, long c) {
            return (int) (num / a + num / b + num / c
                    - num / lcm(a, b)
                    - num / lcm(b, c)
                    - num / lcm(a, c)
                    + num / (lcm(a, lcm(b, c))));
        }

        long gcd(long a, long b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }

        long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }
    }

    static class SuperUglyNumber {
        public int nthSuperUglyNumberI(int n, int[] primes) {
            int[] ugly = new int[n];
            int[] idx = new int[primes.length];

            ugly[0] = 1;
            for (int i = 1; i < n; i++) {
                //find next
                ugly[i] = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
                }

                //slip duplicate
                for (int j = 0; j < primes.length; j++) {
                    while (primes[j] * ugly[idx[j]] <= ugly[i]) {
                        idx[j]++;
                    }
                }
            }

            return ugly[n - 1];
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ugly = new int[n];
            int[] idx = new int[primes.length];
            int[] val = new int[primes.length];
            Arrays.fill(val, 1);

            int next = 1;
            for (int i = 0; i < n; i++) {
                ugly[i] = next;

                next = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    //skip duplicate and avoid extra multiplication
                    if (val[j] == ugly[i]) {
                        val[j] = ugly[idx[j]++] * primes[j];
                    }
                    //find next ugly number
                    next = Math.min(next, val[j]);
                }
            }

            return ugly[n - 1];
        }

        public int nthSuperUglyNumberHeap(int n, int[] primes) {
            int[] ugly = new int[n];

            PriorityQueue<Num> pq = new PriorityQueue<>();
            for (int prime : primes) {
                pq.add(new Num(prime, 1, prime));
            }
            ugly[0] = 1;

            for (int i = 1; i < n; i++) {
                ugly[i] = pq.peek().val;
                while (pq.peek().val == ugly[i]) {
                    Num nxt = pq.poll();
                    pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
                }
            }

            return ugly[n - 1];
        }

        private static class Num implements Comparable<Num> {
            int val;
            int idx;
            int p;

            public Num(int val, int idx, int p) {
                this.val = val;
                this.idx = idx;
                this.p = p;
            }

            @Override
            public int compareTo(Num that) {
                return this.val - that.val;
            }
        }
    }
}
