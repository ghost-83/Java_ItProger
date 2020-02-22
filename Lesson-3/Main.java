package com.itProger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int a = 0;
//        a--;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите 1 число: ");
        float a = in.nextFloat();
        System.out.print("Введите 2 число: ");
        float b = in.nextShort();

//        String num_0 = "10";

        System.out.println("Результаты:");
        System.out.println("Сумма - " + (a + b));
        System.out.println("Разница - " + (a - b));
        System.out.println("Умножение - " + (a * b));

        float res = a / b;
//        float res_2 = a + b + Integer.parseInt(num_0);

        System.out.println("Деление - " + res);
        System.out.println("Остаток от деления - " + (a % b));


        // Получение данных от пользователя
//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите число: ");
//        double num = in.nextDouble();
//        System.out.print(num);
//
//        char symbol = in.next().charAt(0);
//        System.out.print(symbol);

        // Работа с переменными и их типами
//        short number = 200;
//        number = 11;
//        long big_num = 100000000;
//
//        short a, b = 0;
//
//        String str = "Переменная равна: ";
//
//        System.out.println(str + number);
//
//        float num_float = 5.76f;
//        double num_double = 5.35467864324543d;
//        System.out.println(str + num_float + ", 2: " + num_double);
//
//        boolean haveCar = false;
//        char sym = 'г';
//        System.out.println(str + sym);
    }
}
