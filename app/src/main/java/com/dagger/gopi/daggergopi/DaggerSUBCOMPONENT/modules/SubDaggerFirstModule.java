package com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.modules;

import com.dagger.gopi.daggergopi.R;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 06/03/18.
 */
@Module
public class SubDaggerFirstModule {

    @Provides
    @Named("SubDummyStringAry")
    public String[] dummyStringArray() {
        return new String[]{"subA", "subB", "subC"};
    }

}
