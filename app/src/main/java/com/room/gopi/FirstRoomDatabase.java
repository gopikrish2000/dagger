package com.room.gopi;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by gopi on 15/03/18.
 */
@Database(entities = {StudentEntity.class}, version = 1)
@TypeConverters({RoomTypeConverter.class})
public abstract class FirstRoomDatabase extends RoomDatabase {
    public abstract FirstRoomDao getFirstRoomDao();
}
