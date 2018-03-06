package com.dagger.gopi.daggergopi.daggermodules;

import android.content.Context;

import com.dagger.gopi.daggergopi.R;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 27/02/18.
 */

@Module
public class DaggerSecondModule {

    Context applicationContext;

    public DaggerSecondModule(Context applicationContext) {  // without default constructor.
        this.applicationContext = applicationContext;
    }

    @Provides
    @Named("dummyStringAry")
    @Singleton
    public String[] dummyStringArray() {
        return new String[]{applicationContext.getString(R.string.app_name), "b", "c"};  // use application context here
    }
}
