package com.ghost;

import java.io.*;
import java.util.Scanner;

public class Main {
// Надеюсь что не сильно нарушил правила реализации поставленной задачи.
    private static People people = new People();
    private static boolean process  = true;
    private static String fileName = "Save.data";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        read();

        while (process){
            System.out.println("Введите цифру нужного варианта:");
            System.out.println("1 Добавить пользователя");
            System.out.println("2 Вывести");
            System.out.println("0 Выход");
            option = scanner.nextInt();
            if(option == 1)
                write();
            else if (option ==2)
                people.getUsers();
            else process = false;
        }
    }

    public static void write(){
        people.addUser();
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(people);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(){

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(file);
            people = (People) ois.readObject();

        } catch (IOException e) {
            System.out.println("Фаил сохранений не найден, или поврежден!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
