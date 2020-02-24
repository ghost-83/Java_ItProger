package com.itProger;

public class Main {

    public static void main(String[] args) {
        Person bob = new Person(23, Personality.MALE);
        System.out.println(bob.getAge());
        bob.talk();

        UFO alien = new UFO(893, Personality.ALIEN);
        System.out.println(alien.getAge());
        alien.talk();

        if(alien.person == Personality.ALIEN)
            System.out.println("Да");
    }

}