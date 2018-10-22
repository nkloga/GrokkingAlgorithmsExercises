package com.company;

import java.util.*;

public class Greedy {

    public static void main(String[] args) {
        HashSet<String> states_needed = new HashSet<String>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        System.out.println(states_needed);
        HashMap<String, HashSet<String>> stations = new HashMap<>();
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        Set<String> final_stations = new HashSet<>();
        while (states_needed.size() != 0) {
            String best_station = null;
            Set<String> states_covered = new HashSet<>();

            for (Map.Entry<String, HashSet<String>> entry : stations.entrySet()) {
                Set<String> covered = new HashSet<String>(states_needed);
                covered.retainAll(entry.getValue());
                if (covered.size() > states_covered.size()) {
                    best_station = entry.getKey();
                    states_covered = covered;
                }
                states_needed.removeAll(states_covered);
                if (best_station != null) {
                    final_stations.add(best_station);
                }
            }
        }
        System.out.println(final_stations);
    }
}
