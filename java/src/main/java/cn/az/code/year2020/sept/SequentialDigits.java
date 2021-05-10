package cn.az.code.year2020.sept;

import java.util.*;

/**
 * @author az
 * @since 09/20/20
 */
public class SequentialDigits {

    public List<Integer> sequentialDigits1(int low, int high) {
        int MOD = 1000000000;
        List<Integer> result = new ArrayList<>();
        if (low < 10 || high > MOD) {
            return result;
        }
        int lowDigit = getDigit(low);
        int highDigit = getDigit(high);
        String source = "0123456789";
        for (int i = lowDigit; i <= highDigit; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                String cur = source.substring(j, j + i);
                int candidate = Integer.parseInt(cur);
                if (candidate >= low && candidate <= high) {
                    result.add(candidate);
                } else if (candidate > high) {
                    break;
                }
            }
        }
        return result;
    }

    public int getDigit(int origin) {
        int digit = 0;
        while (origin > 0) {
            digit++;
            origin /= 10;
        }
        return digit;
    }

    public List<Integer> sequentialDigits2(int low, int high) {
        int MOD = 1000000000;
        List<Integer> result = new ArrayList<>();
        if (low < 10 || high > MOD) {
            return result;
        }
        for (int i = 1; i <= 9; i++) {
            backtrace(result, i, 0, low, high);
        }
        Collections.sort(result);
        return result;
    }

    public void backtrace(List<Integer> result, int start, int target, int low, int high) {
        if (target >= low && target <= high) {
            result.add(target);
        }
        if (start > 9 || target > high) {
            return;
        }
        backtrace(result, start + 1, target * 10 + start, low, high);
    }

    public List<Integer> sequentialDigits3(int low, int high) {
        int MOD = 1000000000;
        List<Integer> result = new ArrayList<>();
        if (low < 10 || high > MOD) {
            return result;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int target = queue.poll();
            if (target >= low && target <= high) {
                result.add(target);
            }
            int tail = target % 10;
            if (tail < 9 && target <= high) {
                queue.offer(target * 10 + tail + 1);
            }
        }
        return result;
    }

    public List<Integer> sequentialDigits4(int low, int high) {
        int MOD = 1000000000;
        List<Integer> result = new ArrayList<>();
        if (low < 10 || high > MOD) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 9; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int target = stack.pop();
            if (target >= low && target <= high) {
                result.add(target);
            }
            int tail = target % 10;
            if (tail < 9 && target <= high) {
                stack.push(target * 10 + tail + 1);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Integer> sequential(int low, int high) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) {
            q.offer(i);
        }
        List<Integer> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            int front = q.peekFirst();
            q.pop();
            if (front <= high && front >= low) {
                ret.add(front);
            }
            if (front > high) {
                break;
            }
            int num = front % 10;
            if (num < 9) {
                q.offer(front * 10 + (num + 1));
            }
        }
        return ret;
    }

    public List<Integer> seq(int low, int high) {

        int[] allNums = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789};
        List<Integer> res = new ArrayList<>();
        for (int allNum : allNums) {
            if (allNum < low) {
                continue;
            }
            if (allNum > high) {
                break;
            }
            res.add(allNum);
        }
        return res;
    }
}
