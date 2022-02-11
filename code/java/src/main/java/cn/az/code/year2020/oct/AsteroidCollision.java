package cn.az.code.year2020.oct;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author az
 * @since 10/21/20
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || s.isEmpty() || s.getLast() < 0)
                s.add(asteroids[i]);
            else if (s.getLast() <= -asteroids[i])
                if (s.pollLast() < -asteroids[i]) i--;
        }
        return s.stream().mapToInt(i -> i).toArray();
    }

    public int[] asteroidCollision_(int[] asteroids) {

        Stack<Integer> s = new Stack<>();
        for (int a : asteroids) {
            if (!s.empty() && s.peek() * a < 0) {
                int b = s.pop();
                if (a + b != 0) {
                    s.push(Math.abs(a) > Math.abs(b) ? a : b);
                }
            } else {
                s.push(a);
            }
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}
