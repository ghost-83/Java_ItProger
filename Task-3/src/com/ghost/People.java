package com.ghost;

import java.io.Serializable;
import java.util.LinkedList;

public class People implements Serializable {

    private LinkedList <User> people = new LinkedList<>();

    public void addUser (){
        people.add(new User());

    }

    public void getUsers (){
        for (User user : people){
            user.getAll();
        }

    }
}
