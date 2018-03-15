package com.room.gopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dagger.gopi.daggergopi.R;
import com.others.GopiApplication;
import com.room.gopi.daggerWrapper.DaggerRoomComponent;
import com.room.gopi.daggerWrapper.RoomComponent;
import com.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RoomDbActivity extends AppCompatActivity {

    private FirstRoomDao firstRoomDao;
    private ItemStudentAdapter itemStudentAdapter;
    @Inject
    FirstRoomDatabase firstRoomDatabase;
    /*@Inject @Named("roomDummy")
    List<String> dummyDataList;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);
        init();
        Utils.getApplicationInstance().getApplicationComponent().inject(this);
        /*RoomComponent roomComponent = DaggerRoomComponent.builder().build();  // cannot use both injects DONNO Y
        roomComponent.inject(this);*/
        firstRoomDao = firstRoomDatabase.getFirstRoomDao();
        firstRoomDao.getAllStudents().observe(this, list -> {
            if(list != null && !list.isEmpty()) {
                itemStudentAdapter.updateData(list);
            }
        });
        Observable<Object> dbObservable = Observable.create((source) -> {
            firstRoomDao.insert(getDummyStudentList());
            source.onNext(true);
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        findViewById(R.id.room_insert_btn).setOnClickListener(view -> {
            dbObservable.subscribe((object) -> {
               // not doing anything.
            });
        });
    }

    private void init() {
        itemStudentAdapter = new ItemStudentAdapter();
        RecyclerView recyclerView = findViewById(R.id.room_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemStudentAdapter);
    }

    private List<StudentEntity> getDummyStudentList() {
        List<StudentEntity> list = new ArrayList<>();
        list.add(new StudentEntity("student1", "stud1", 21, 44, new Date()));
        list.add(new StudentEntity("student2", "stud2", 24, 49, new Date()));
        list.add(new StudentEntity("student3", "stud3", 27, 55, new Date()));
        return list;
    }
}
