package com.company;
import java.util.ArrayList;
public class QuickSort {

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
        System.out.println("Quick sorted list:     " + quicksort(list));

    }

    public static ArrayList<Integer> quicksort (ArrayList<Integer> list) {
        int pivot;
        if(list.size()<2) return list;
        else {
            pivot = list.get(0);
            ArrayList<Integer> greater = new ArrayList<>();
            ArrayList<Integer> less = new ArrayList<>();

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > pivot) greater.add(list.get(i));
                else less.add(list.get(i));
            }

            ArrayList<Integer> result = new ArrayList<>(quicksort(less));
            result.add(pivot);
            result.addAll(quicksort(greater));
            return result;
        }
    }

}
