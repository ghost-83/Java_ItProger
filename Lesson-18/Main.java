package com.itProger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        Course[] objects = {
                new Course(1, "Android"),
                new Course(2, "Kotlin")
        };

        try {
            FileOutputStream fos = new FileOutputStream("main.itproger");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(objects);
//            oos.writeObject(kotlin);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
