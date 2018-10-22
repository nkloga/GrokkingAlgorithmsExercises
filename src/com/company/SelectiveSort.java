package com.company;
import java.util.ArrayList;

public class SelectiveSort {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(4);
        list.add(76);
        list.add(3);
        list.add(9);
        list.add(71);
        list.add(21);
        list.add(44);
        System.out.println("Initial list:          " + list);
        System.out.println("Selective sorted list: " + selectiveSort(list));
    }

    public static ArrayList<Integer> selectiveSort(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (list.size() != 0) {
            int max = list.get(0);
            int maxIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < max) {
                    max = list.get(i);
                    maxIndex = i;
                }
            }
            sortedList.add(max);
            list.remove(maxIndex);
        }
        return sortedList;
    }
}
