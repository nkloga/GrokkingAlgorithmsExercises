package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        System.out.println("Guess some number between 0 and 100: ");

        int low = array[0];
        int high = array[100 - 1];

        while (true) {
            int mid = (high + low) / 2;

            if (high - mid == 1) {
                System.out.println("your number is " + mid);
                return;
            }
            System.out.println("is the number bigger than " + mid + "? (yes/no)");
            if (reader.readLine().toLowerCase().equals("yes")) {
                low = mid;
            } else {
                high = mid;
            }

        }

    }
}
