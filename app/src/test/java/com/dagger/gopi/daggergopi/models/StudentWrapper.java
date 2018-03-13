package com.dagger.gopi.daggergopi.models;

/**
 * Created by gopi on 13/03/18.
 */

public class StudentWrapper {

    Student student;
    Institute institute;

    public StudentWrapper() {
    }

    public Student getStudent() {
        return student;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public void printDetails() {
        System.out.println("student howGoodStudentPercent " + student.howGoodStudentPercent() + " institute " + institute);
    }
}
