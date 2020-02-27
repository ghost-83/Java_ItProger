package com.ghost;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {

    private String name;
    private String userName;
    private String age;
    private String[] hobbies;

    User(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = scan.nextLine();
        System.out.print("Введите логин: ");
        this.userName = scan.nextLine();
        System.out.print("Введите возраст: ");
        this.age = scan.nextLine();
        System.out.print("Введите хобби через запятую: ");
        this.hobbies = scan.nextLine().split("[ ,]+");
    }

    public void getAll(){
        System.out.print("Ползователь: " + name + " с логином: " + userName +". ");
        System.out.println("Его возраст: " + age + ". Все хобби:");
        for (String hob : hobbies){
            System.out.println(hob);
        }

    }

}
