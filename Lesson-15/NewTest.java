package com.itProger;

public class NewTest implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++)
            System.out.println("Элемент: " + i);
    }
}
