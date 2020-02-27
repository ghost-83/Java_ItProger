package com.itProger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Proccess obj = new Proccess();
//        obj.start();
//
//        System.out.println("Нажмите на любую клавишу:");
//        Scanner in = new Scanner(System.in);
//        in.nextLine();
//
//        obj.exit();

        final Car bmw = new Car();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bmw.moveCar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bmw.stopCar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
