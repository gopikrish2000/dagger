package com.room.gopi.daggerWrapper;

import android.arch.persistence.room.RoomDatabase;

import com.dagger.gopi.daggergopi.annotations.PerApplication;
import com.others.GopiApplication;
import com.room.gopi.FirstRoomDatabase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 15/03/18.
 */

@Module
@PerApplication
public class ApplicationModules {

    private final GopiApplication gopiApplication;

    public ApplicationModules(GopiApplication gopiApplication) {
        this.gopiApplication = gopiApplication;
    }

    @PerApplication
    @Provides
    public GopiApplication provideApplicationContext() {
        return gopiApplication;
    }

    @PerApplication
    @Provides
    public FirstRoomDatabase provideRoomDb() {
        return gopiApplication.getRoomdb();
    }
}
