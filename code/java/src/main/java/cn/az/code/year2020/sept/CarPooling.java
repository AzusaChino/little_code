package cn.az.code.year2020.sept;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

/**
 * @author az
 * @since 09/21/20
 */
public class CarPooling {

    public static void main(String[] args) {
        CarPooling cp = new CarPooling();
        int[][] trips = {{12, 93, 896}, {77, 291, 904}, {78, 424, 659}, {41, 668, 962}, {79, 2, 493}, {7, 369, 840},
                {60, 229, 928}, {41, 7, 163}, {46, 621, 736}, {97, 958, 984}, {53, 832, 980}, {15, 218, 815}, {24, 74, 428}, {12, 415, 959},
                {20, 81, 85}, {45, 567, 601}, {17, 266, 535}, {65, 828, 943}, {30, 416, 432}, {27, 48, 142}, {52, 413, 756}, {21, 79, 274},
                {4, 260, 387}, {49, 180, 314}, {51, 628, 880}, {94, 271, 462}, {41, 163, 457}, {30, 187, 925}, {39, 349, 999}, {5, 289, 809},
                {9, 214, 374}, {10, 302, 534}, {59, 412, 778}, {77, 306, 497}, {17, 594, 839}, {53, 404, 892}, {5, 525, 844}, {89, 275, 619},
                {2, 27, 310}, {79, 473, 755}, {10, 812, 853}, {76, 55, 549}, {100, 643, 770}, {36, 701, 997}, {59, 354, 475}, {70, 586, 924},
                {60, 146, 972}, {32, 121, 305}, {27, 75, 132}, {17, 32, 758}, {24, 389, 465}, {81, 55, 258}, {70, 74, 728}, {36, 184, 703},
                {66, 603, 853}, {63, 319, 964}, {15, 355, 676}, {69, 312, 521}, {83, 344, 995}, {41, 73, 439}, {28, 384, 758}, {90, 341, 365},
                {11, 473, 980}, {49, 631, 737}, {6, 116, 531}, {99, 334, 460}, {78, 358, 508}, {26, 426, 823}, {10, 312, 677}, {48, 532, 711},
                {64, 433, 635}, {62, 591, 765}, {100, 150, 837}, {24, 60, 945}, {6, 72, 237}, {21, 602, 838}, {75, 255, 629}, {54, 824, 935},
                {53, 169, 263}, {49, 401, 744}, {1, 603, 922}, {88, 284, 984}, {25, 896, 998}, {13, 379, 493}, {2, 293, 295}, {31, 106, 600},
                {91, 284, 631}, {42, 16, 880}, {89, 62, 803}, {96, 168, 279}, {8, 731, 902}, {44, 348, 755}, {68, 462, 537}, {96, 694, 913},
                {51, 190, 651}, {7, 92, 179}, {91, 5, 65}, {14, 338, 818}, {98, 423, 953}, {15, 636, 664}};

        System.out.println(cp.carPooling(trips, 2637));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        // save order
        Map<Integer, Function<Integer, Integer>> map = new TreeMap<>();
        for (int[] t : trips) {
            int people = t[0], start = t[1], end = t[2];
            if (map.containsKey(start)) {
                map.put(start, map.get(start).andThen(x -> x + people));
            } else {
                map.put(start, x -> x + people);
            }
            if (map.containsKey(end)) {
                map.put(end, map.get(end).andThen(x -> x - people));
            } else {
                map.put(end, x -> x - people);
            }
        }
        int ret = 0;
        for (Map.Entry<Integer, Function<Integer, Integer>> entry : map.entrySet()) {
            ret = entry.getValue().apply(ret);
            if (ret > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        for (int[] t : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i) {
            capacity -= stops[i];
        }
        return capacity >= 0;
    }

}
