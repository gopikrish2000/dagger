package com.dagger.gopi.daggergopi.daggermodules;

import android.support.v4.util.Pair;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 26/02/18.
 */
@Module // can write includes @Module(includes = { DaggerSecondModule.class})
public class DaggerFirstModule {

    @Provides
    @Singleton
    public Executor getExecutor() {
        System.out.println("DaggerFirstModule.getExecutor creating the instance here");
        return Executors.newSingleThreadExecutor();
    }

    @Provides  //provides method can internally use the other @Provides methods like Executor & String[] of DaggerSecondModule
    public Pair<Executor, String[]> provideExecutorPair(Executor executor, @Named("dummyStringAry") String[] stringAry) {
        return Pair.create(executor, stringAry);
    }
}
