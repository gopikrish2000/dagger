package com.room.gopi;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by gopi on 15/03/18.
 */
@Dao
public interface FirstRoomDao {

    @Query("select * from StudentEntity Where studentId = :studentId")
    StudentEntity getStudent(String studentId);

    @Query("select * from StudentEntity")
    LiveData<List<StudentEntity>> getAllStudents();

    @Insert
    void insert(List<StudentEntity> studentEntities);

    @Update
    void update(StudentEntity studentEntity);

    @Delete
    void delete(StudentEntity studentEntity);
}
