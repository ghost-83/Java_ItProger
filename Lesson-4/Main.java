package com.itProger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        byte num = 12;
        switch(num) {
            case 1:
                System.out.print("Переменная равна 1");
                break;
            case 23:
                System.out.print("Переменная равна 23");
                break;
            case 10:
                System.out.print("Переменная равна 10");
                break;
            case 100:
                System.out.print("Переменная равна 100");
                break;
            case 89:
                System.out.print("Переменная равна 89");
                break;
                default:
                    System.out.print("Переменная равна чему-то другому");
        }

        short x = 15, a = 12;
        int res = x < a ? (x + a) : (x - a);
        System.out.println(res);

        System.out.print("Введите ваш возраст: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();

        boolean withParents = in.nextBoolean();

        if(age < 18) {
            if(age >= 10 && age <= 15 && withParents)
                System.out.print("Вам сейчас от 10 до 15 лет и вы с родителями");
            else if((age == 7 || age == 9) && !withParents)
                System.out.print("Вам вход бесплатный");
        } else if(age == 18)
            System.out.print("Вам уже 18 лет");
        else if(age == 19) {
            System.out.print("Вам уже 19 лет");
        } else {
            if(age >= 50)
                System.out.print("Вам уже более 50 лет");
            else
                System.out.print("Вам еще менее 50 лет");
        }

    }
}
