package com.itProger;

public class Elements extends Thread {
    public void run() {
        for(int i = 1; i <= 10; i++)
            System.out.println("Элемент: " + i);
    }
}
