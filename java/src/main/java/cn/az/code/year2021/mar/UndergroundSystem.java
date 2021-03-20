package cn.az.code.year2021.mar;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @since 03/20/21 21:33
 */
public class UndergroundSystem {

    // Route - {TotalTime, Count}

    Map<String, Pair<Integer, Integer>> checkoutMap = new HashMap<>();

    // Uid - {StationName, Time}

    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        String route = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));
        checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        Pair<Integer, Integer> checkout = checkoutMap.get(route);
        return (double) checkout.getKey() / checkout.getValue();
    }
}
