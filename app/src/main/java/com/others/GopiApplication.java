package com.others;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.room.gopi.FirstRoomDatabase;
import com.room.gopi.daggerWrapper.ApplicationComponents;
import com.room.gopi.daggerWrapper.ApplicationModules;
import com.room.gopi.daggerWrapper.DaggerApplicationComponents;

/**
 * Created by gopi on 15/03/18.
 */

public class GopiApplication extends Application {
    private static GopiApplication application;
    private FirstRoomDatabase roomdb;
    private ApplicationComponents applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        roomdb = Room.databaseBuilder(this, FirstRoomDatabase.class, "roomdb").build();
        applicationComponent = DaggerApplicationComponents.builder().applicationModules(new ApplicationModules(application)).build();
    }

    public static GopiApplication getInstance() {
        return application;
    }

    public FirstRoomDatabase getRoomdb() {
        return roomdb;
    }

    public ApplicationComponents getApplicationComponent() {
        return applicationComponent;
    }
}
