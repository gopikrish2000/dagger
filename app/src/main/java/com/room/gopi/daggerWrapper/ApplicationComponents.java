package com.room.gopi.daggerWrapper;

import com.dagger.gopi.daggergopi.annotations.PerApplication;
import com.room.gopi.RoomDbActivity;

import dagger.Component;

/**
 * Created by gopi on 15/03/18.
 */

@PerApplication
@Component(modules = {ApplicationModules.class})
public interface ApplicationComponents {
    void inject(RoomDbActivity activity);
}
