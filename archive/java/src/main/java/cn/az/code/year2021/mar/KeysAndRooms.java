package cn.az.code.year2021.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author ycpang
 * @since 2021-03-19 16:24
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms kr = new KeysAndRooms();
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1, 3));
        l.add(Arrays.asList(3, 0, 1));
        l.add(Arrays.asList(2));
        l.add(Arrays.asList(0));
        System.out.println(kr.$$can(l));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int sz = rooms.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < sz; i++) {
            List<Integer> list = rooms.get(i);
            set.addAll(list);
            if (!set.contains(i + 1) && i != sz - 1) {
                return false;
            }
        }
        return true;
    }

    public boolean $can(List<List<Integer>> rooms) {
        int sz = rooms.size();
        Set<Integer> s = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        // initial point
        set.add(0);
        for (int i = 0; i < sz; i++) {
            s.add(i);
            List<Integer> list = rooms.get(i);
            set.addAll(list);
        }
        for (int i : s) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean $$can(List<List<Integer>> rooms) {
        int sz = rooms.size();
        boolean[] visited = new boolean[sz];

        helper(rooms, 0, new ConcurrentSkipListSet<>(), visited);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void helper(List<List<Integer>> rooms, int currentRoom, Set<Integer> keys, boolean[] visited) {
        // 1. 如果已经访问过，直接返回
        if (visited[currentRoom]) {
            return;
        }
        visited[currentRoom] = true;

        // 2. add all keys
        keys.addAll(rooms.get(currentRoom));
        for (int k : keys) {
            helper(rooms, k, keys, visited);
        }
    }
}
