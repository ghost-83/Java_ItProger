package com.itProger;

public class Main {

    public static void main(String[] args) {
        final int num = 230;
//        Car bmw = new Car((short) num);
//        bmw.setAll("M3", 1238.5f, "Белый", false);
//        bmw.printAll();

        BMW m5 = new BMW(false, "M5", 2500.23f, "Синий", true, (short) 300);
        m5.printAll();
        m5.startEngine();

//        Car mercedes = new Car("S500", 3002.58f, "Черный", true);
//        mercedes.speed = 320;
//
//        Car audi = new Car("R8", 2081.3f, "Серебристый", true);
//        audi.speed = 320;

//        BMW.printTest();
//        System.out.println(BMW.num);
    }

}
