package cn.az.code.year2021.sept;

/**
 * @author az
 * @since 2021-9-6
 */
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDifference = releaseTimes[0];
        char bestChar = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int difference = releaseTimes[i] - releaseTimes[i - 1];

            if (
                difference > maxDifference ||
                (
                    difference == maxDifference &&
                    keysPressed.charAt(i) > bestChar
                )
            ) {
                maxDifference = difference;
                bestChar = keysPressed.charAt(i);
            }
        }
        return bestChar;
    }
}
