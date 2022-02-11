package cn.az.code.year2020.jun;

import java.util.*;

/**
 * @author az
 * @since 2020-06-28 22:06
 */
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<>();

    void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll());
        }
        route.add(0, airport);
    }


    public List<String> _findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>(16);
        for (String[] ticket : tickets) {
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                stack.push(targets.get(stack.peek()).poll());
            }
            route.add(0, stack.pop());
        }
        return route;
    }
}
