package com.room.gopi;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by gopi on 15/03/18.
 */

public class RoomTypeConverter {

    @TypeConverter
    public static Date convertToDate(long timeStamp) {
        return new Date(timeStamp);
    }

    @TypeConverter
    public static long convertToLong(Date date) {
        return date.getTime();
    }
}
