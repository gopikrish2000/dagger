package com.room.gopi.daggerWrapper;

import com.dagger.gopi.daggergopi.annotations.PerActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 15/03/18.
 */
@Module
public class RoomModules {

    @Provides
    @Named("roomDummy")
    public List<String> providesRoomDataStringList() {
        return Arrays.asList("aa", "bb", "cc", "dd");
    }
}
