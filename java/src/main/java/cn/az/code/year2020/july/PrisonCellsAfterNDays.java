package cn.az.code.year2020.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @since 2020-07-04 10:33
 */
public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        PrisonCellsAfterNDays pc = new PrisonCellsAfterNDays();
        pc.prisonAfterNDays(cells, 7);
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) {
            return cells;
        }
        boolean hasCycle = false;
        int cycle = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) { //store cell state
                set.add(key);
                cycle++;
            } else { //hit a cycle
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] tmp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return tmp;
    }


    public int[] _prisonAfterNDays(int[] cells, int N) {
        for (int i = 0; i < N; i++) {
            changeCell(cells);
        }
        return cells;
    }

    private void changeCell(int[] cells) {
        for (int j = 1; j < cells.length - 1; j++) {
            if (cells[j - 1] == cells[j + 1]) {
                cells[j] = 1;
            } else {
                cells[j] = 0;
            }
        }
        System.out.println(Arrays.toString(cells));
    }
}
