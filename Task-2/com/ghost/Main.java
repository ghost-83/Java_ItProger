package com.ghost;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String name;
        Player.VARIANT variant = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру 'КАМЕНЬ НОЖНИЦИ БУМАГА'\n");
        System.out.print("Введите ваше имя: ");
        name = scan.nextLine();

        System.out.println("\n Введите цифру вашего варианта:");
        System.out.println("1. Камень \n2. Ножници \n3. Бумага");
        int numb = scan.nextInt();

        if (numb == 1)
            variant = Player.VARIANT.ROCK;
        else if (numb == 2)
            variant = Player.VARIANT.SCISSORS;
        else if (numb == 3)
            variant = Player.VARIANT.PAPER;
        else
            System.out.println("Вы ввели неправильное число!");

        Player bot = new Player();
        Player user = new Player(variant, name);

        System.out.println(bot.whoWins(bot, user));
    }
}
