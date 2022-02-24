package cn.az.code.year2020.aug;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author az
 * @since 08/26/20
 */
public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(FizzBuzz.generateFizzBuzz(15));
    }

    public static List<String> generateFizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        int cnt3 = 3;
        int cnt5 = 5;
        for (int i = 1; i <= n; i++) {
            if (i == cnt3 && i == cnt5) {
                res.add("FizzBuzz");
                cnt3 += 3;
                cnt5 += 5;
            } else if (i == cnt3) {
                cnt3 += 3;
                res.add("Fizz");
            } else if (i == cnt5) {
                cnt5 += 5;
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }

    static class FizzBuzzMultiThread {

        private final int n;
        private final Semaphore sem;
        private final Semaphore sem3;
        private final Semaphore sem5;
        private final Semaphore sem15;

        public FizzBuzzMultiThread(int n) {
            this.n = n;
            sem = new Semaphore(1);
            sem3 = new Semaphore(0);
            sem5 = new Semaphore(0);
            sem15 = new Semaphore(0);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                sem3.acquire();
                printFizz.run();
                if ((i + 3) % 5 == 0) // skip multiples of 15.
                {
                    i += 3;
                }
                sem.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                sem5.acquire();
                printBuzz.run();
                if ((i + 5) % 3 == 0) // skip multiples of 15.
                {
                    i += 5;
                }
                sem.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                sem15.acquire();
                printFizzBuzz.run();
                sem.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; ++i) {
                sem.acquire();
                if (i % 15 == 0) {
                    sem15.release();
                } else if (i % 5 == 0) {
                    sem5.release();
                } else if (i % 3 == 0) {
                    sem3.release();
                } else {
                    printNumber.accept(i);
                    sem.release();
                }
            }
        }

    }
}
