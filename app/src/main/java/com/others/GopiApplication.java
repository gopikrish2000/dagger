package com.others;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.room.gopi.FirstRoomDatabase;

/**
 * Created by gopi on 15/03/18.
 */

public class GopiApplication extends Application {
    private static GopiApplication application;
    private FirstRoomDatabase roomdb;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        roomdb = Room.databaseBuilder(this, FirstRoomDatabase.class, "roomdb").build();
    }

    public static GopiApplication getInstance() {
        return application;
    }

    public FirstRoomDatabase getRoomdb() {
        return roomdb;
    }
}
