package com.itProger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        byte[] nums_array = new byte[8];
        nums_array[0] = 4;
        nums_array[1] = 100;
        nums_array[1] += 10;

        byte[] new_array = Arrays.copyOf(nums_array, nums_array.length);

        String[] names = new String[] { "Петр", "", "Гоша", "Андрей" };
        names[0] = "Вова";
        System.out.println(Arrays.toString(nums_array));
        Arrays.sort(new_array);
        System.out.println(Arrays.toString(new_array));

        int[][] arr_2 = new int[5][5];
        int[][] arr = new int[][] {
                { 5, 7, 8, 5 },
                { 8, 27, 18, 5 },
                { 5, 7, 8, 5 }
        };
        arr[1][2] = 45;
//        System.out.println(arr[1][2]);

        ArrayList<Integer> arr_dynamic = new ArrayList<>(0);
        arr_dynamic.add(45);
        arr_dynamic.add(145);
        arr_dynamic.add(23);
        arr_dynamic.add(8);
        arr_dynamic.add(13);
        arr_dynamic.set(0, 23);
//        arr_dynamic.clear();
        arr_dynamic.remove(1);
        System.out.print(arr_dynamic.get(0));

        LinkedList<String> words = new LinkedList<>();
        words.add("Hello");
        words.add("World");

        System.out.print(words.get(0));
    }
}
