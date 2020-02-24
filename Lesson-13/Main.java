package com.itProger;

public class Main {

    public static void main(String[] args) {
        BMW m5 = new BMW(false, "M5", 2500.23f, "Синий", true, (short) 300);
        m5.printAll();
        m5.startEngine();

        Audi obj = new Audi() {
            private boolean isWork;

            public void isDrive() {
                this.isWork = true;
            }

            public void printAll() {
                System.out.println(isWork);
            }
        };

        obj.printAll();
        obj.isDrive();
        obj.printAll();

    }

    private static class Audi {
        public void printAll() { }
        public void isDrive() { }
    }
}
