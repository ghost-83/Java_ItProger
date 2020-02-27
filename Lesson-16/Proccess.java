package com.itProger;

public class Proccess extends Thread {

    private volatile boolean isRun = true;

    public void run() {
        while(isRun) {
            System.out.println("Привет");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void exit() {
        isRun = false;
    }

}
