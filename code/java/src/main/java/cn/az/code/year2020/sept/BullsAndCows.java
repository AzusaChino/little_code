package cn.az.code.year2020.sept;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author az
 * @since 09/10/20
 */
public class BullsAndCows {

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        System.out.println(bc.getHint("1807", "7810"));
        System.out.println(bc.getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (numbers[secret.charAt(i) - '0']++ < 0) {
                    cows++;
                }
                if (numbers[guess.charAt(i) - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHintWrong(String secret, String guess) {
        int[] secrets = Arrays.stream(secret.split("")).mapToInt(Integer::parseInt).toArray();
        int[] guesses = Arrays.stream(guess.split("")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> set = Arrays.stream(secrets).boxed().collect(Collectors.toSet());
        int four = 4;
        int bull = 0, cow = 0;
        for (int i = 0; i < four; i++) {
            // 1. 相同的情况
            if (secrets[i] == guesses[i]) {
                bull++;
            } else {
                if (set.contains(guesses[i])) {
                    cow++;
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}
