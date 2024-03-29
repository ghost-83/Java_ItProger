package com.itProger;

public class Course {

    private int id;
    private String title;

    public Course(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public String toString() {
        return id + " - " + title;
    }

    public boolean equals(Object obj) {
        Course course = (Course) obj;
        return id == course.id;
    }

}
