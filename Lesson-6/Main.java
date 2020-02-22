package com.itProger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int i = 0;
        while(i < 10) {
            if(i == 5)
                break;
            if(i % 2 == 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

        // Вывод динамического массива
//        ArrayList<String> names = new ArrayList<>(0);
//        names.add("Боб");
//        names.add("Мартин");
//        names.add("Пётр");
//        names.add("Иван");
//        names.add("Алексей");
//
//        for(String el : names)
//            System.out.println(el);

        // Вывод двумерного массива
//        int[][] big_nums = new int[][]{
//                {5, 7, 1, 234},
//                {2, 3, 8, 122},
//                {543, 9, 0, 4},
//                {56, 98, 6, 0}
//        };
//
//        for(int i = 0; i < big_nums.length; i++) {
//            for(int j = 0; j < big_nums[i].length; j++) {
//                System.out.print(big_nums[i][j] + " ");
//            }
//            System.out.println("");
//        }

        // Вывод одномерного массива
//        short[] arr = new short[] {5, 7, 1, 234, 3, 8};
//        for(int i = 0; i < arr.length; i++)
//            System.out.println("Значение элемента " + (i + 1) + " = " + arr[i]);

        // Игра на получение данных от пользователя
//        int user_input;
//        Scanner in = new Scanner(System.in);
//        do {
//            System.out.print("Введите число 5: ");
//            user_input = in.nextInt();
//        } while (user_input != 5);
//        System.out.print("Вы молодец!");

        // Три типа циклов
//        for(float el = 100; el > 10; el /= 2) {
//            System.out.println(el);
//        }
//
//        int i = 0;
//        while(i < 10) {
//            System.out.println("Значение переменной: " + i);
//            i++;
//        }
//
//        int j = 100;
//        do {
//            System.out.println("Цикл сработал");
//            j /= 2;
//        } while(j > 10);
    }
}
