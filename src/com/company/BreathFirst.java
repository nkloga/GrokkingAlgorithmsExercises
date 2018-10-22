package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BreathFirst {

    public static class People {
        String name;
        String position;

        public People(String name, String position) {
            this.name = name;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        People me = new People("Me", "owner");
        People Clair = new People("Clair", "friend");
        People Alisa = new People("Alisa", "friend");
        People Bob = new People("Bob", "friend");
        People Anudz = new People("Anudz", "friend");
        People Peggy = new People("Peggy", "friend");
        People Tom = new People("Tom", "mango seller");
        People Jonny = new People("Jonny", "friend");

        HashMap<Object, HashSet<Object>> map = new HashMap<>();

        HashSet<Object> mySet = new HashSet<>();
        HashSet<Object> ClairSet = new HashSet<>();
        HashSet<Object> AlisaSet = new HashSet<>();
        HashSet<Object> BobSet = new HashSet<>();

        mySet.add(Clair);
        mySet.add(Alisa);
        mySet.add(Bob);
        ClairSet.add(Tom);
        ClairSet.add(Jonny);
        AlisaSet.add(Peggy);
        BobSet.add(Anudz);
        BobSet.add(Peggy);

        map.put(me, mySet);
        map.put(Clair, ClairSet);
        map.put(Alisa, AlisaSet);
        map.put(Bob, BobSet);
        map.put(Anudz, null);
        map.put(Peggy, null);
        map.put(Tom, null);
        map.put(Jonny, null);

        ArrayList<Object> queue = new ArrayList<>(mySet);
        ArrayList<Object> checkedNames = new ArrayList<>();

        while (true) {

            if ((((People) queue.get(0)).position).equals("mango seller")) {
                System.out.println(((People) queue.get(0)).name);
                return;
            } else {
                if (!checkedNames.contains(queue.get(0))) {
                    queue.addAll(map.get(queue.get(0)));
                    checkedNames.add(queue.get(0));
                    queue.remove(0);
                }
            }
        }
    }
}