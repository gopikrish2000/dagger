package com.dagger.gopi.daggergopi.models;

/**
 * Created by gopi on 13/03/18.
 */

public class Student {
    private String name;
    private int age;
    private int marks;

    public String getName() {
        return name;
    }

    public String getPersonalizedName(String input) {
        return input + "_personalized";
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    public int howGoodStudentPercent() {
        return ((int) ((getAge() * 0.5) + getMarks()));
    }

    public void voidMethodDoingNothing() {

    }

    public int samplePrint() {
        System.out.println("printing inside Student method samplePrint ");
        return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
