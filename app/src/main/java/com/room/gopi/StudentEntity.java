package com.room.gopi;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by gopi on 15/03/18.
 */

@Entity
public class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    public int autoId;
    public String studentId;
    @ColumnInfo(name = "name")
    public String name;
    public int age;
    public int marks;
    public Date dob;

    public StudentEntity(String studentId, String name, int age, int marks, Date dob) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.dob = dob;
    }

    public StudentEntity() {
    }
}
