package com.room.gopi.daggerWrapper;

import com.dagger.gopi.daggergopi.annotations.PerActivity;
import com.room.gopi.RoomDbActivity;

import dagger.Component;

/**
 * Created by gopi on 15/03/18.
 */
@Component(modules = {RoomModules.class})
@PerActivity
public interface RoomComponent {
//    void inject(RoomDbActivity activity);
}
