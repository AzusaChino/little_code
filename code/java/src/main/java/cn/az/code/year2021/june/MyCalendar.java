package cn.az.code.year2021.june;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author az
 * @since 2021-06-10
 */
public class MyCalendar {
    
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> beforeEnd = calendar.lowerEntry(end);
        if (beforeEnd != null && beforeEnd.getValue() > start) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}
