package com.itProger;

public class UFO implements HumanInreface {
    private int age;
    public Personality person;

    UFO(int age, Personality person) {
        this.age = age;
        this.person = person;
    }

    @Override
    public void talk() {
        System.out.println("Ya inoplanetnoe sushestvo!");
        System.out.println("Персона: " + this.person);
    }

    @Override
    public void walk() {
        System.out.println("Ya inoplanetnoe sushestvo i ya ymeu hodit!");
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
