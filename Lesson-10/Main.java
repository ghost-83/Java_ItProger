package com.itProger;

public class Main {

    public static void main(String[] args) {
        int num = 230;
        Car bmw = new Car((short) num);
//        bmw.speed = 230;
        bmw.setAll("M3", 1238.5f, "Белый", false);
        bmw.printAll();
//        System.out.println(bmw.speed);

        Car mercedes = new Car("S500", 3002.58f, "Черный", true);
        mercedes.speed = 320;
//        mercedes.setAll("S500", 3002.58f, "Черный", true);
//        mercedes.printAll();
//        System.out.println(mercedes.speed);

        Car audi = new Car("R8", 2081.3f, "Серебристый", true);
        audi.speed = 320;
    }

}
