package com.company;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {

        // Hashmap to generate tree with 4 nodes

        HashMap<String, HashMap<String, Integer>> tree = new HashMap<>();

        HashMap<String, Integer> Beginning = new HashMap<>();
        Beginning.put("A", 6);
        Beginning.put("B", 2);

        HashMap<String, Integer> A = new HashMap<>();
        A.put("End", 1);

        HashMap<String, Integer> B = new HashMap<>();
        B.put("A", 3);
        B.put("End",5);

        HashMap<String, Integer> End = new HashMap<>();
        End.put("End",0);

        tree.put("Beginning", Beginning);
        tree.put("A", A);
        tree.put("B", B);
        tree.put("End", null);

// Costs hashmap
        HashMap<String, Integer> costs = new HashMap<>();
        int inf = Integer.MAX_VALUE;
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("End", inf);
        
// Parents hashmap
        HashMap<String,String> parents = new HashMap<>();
        parents.put("A", "Beginning");
        parents.put("B", "Beginning");
        parents.put("End", null);

        String node = get_key(find_lowest_cost_node(costs));
        int new_cost = 0;

        while(true) {
            int cost = get_value(find_lowest_cost_node(costs));
            HashMap<String, Integer> neighbors = tree.get(node);
            if (neighbors == null) break;
            for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
                new_cost = cost + entry.getValue();
                if (costs.get(entry.getKey()) > new_cost) {
                    costs.put(entry.getKey(), new_cost);
                    parents.put(entry.getKey(), node);
                }
            }
            costs.remove(node);
            node = get_key(find_lowest_cost_node(costs));
        }
        System.out.println("Shortest path parents are : " + parents);
        System.out.println("Shortest path cost is : " + get_value(costs));
    }

    public static int get_value(HashMap<String, Integer> map) {
        int value = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            value = entry.getValue();
        }
        return value;
    }

    public static String get_key(HashMap<String, Integer> map) {
        String key = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            key = entry.getKey();
        }
        return key;
    }

    public static HashMap<String,Integer> find_lowest_cost_node(HashMap<String, Integer> costs) {
        int min = Integer.MIN_VALUE;
        String minKey = null;
        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minKey = entry.getKey();
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put(minKey,min);
        return map;
    }
}
