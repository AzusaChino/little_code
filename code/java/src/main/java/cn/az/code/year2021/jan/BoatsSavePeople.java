package cn.az.code.year2021.jan;

import java.util.Arrays;

/**
 * @author az
 * @since 01/13/21 22:32
 */
public class BoatsSavePeople {

    public static void main(String[] args) {
        BoatsSavePeople bap = new BoatsSavePeople();
        System.out.println(bap.savePeople(new int[]{1, 2, 3}, 3));
    }

    public int savePeople(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l < r) {
            count += 1;
            if (people[l] + people[r] <= limit) {
                l += 1;
            }
            r -= 1;
        }
        return count;
    }
}
