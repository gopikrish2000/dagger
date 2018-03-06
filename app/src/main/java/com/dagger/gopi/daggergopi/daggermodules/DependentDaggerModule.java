package com.dagger.gopi.daggergopi.daggermodules;

import com.dagger.gopi.daggergopi.annotations.DependentDaggerCompAnnotation;

import java.util.HashMap;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 06/03/18.
 */
@Module
public class DependentDaggerModule {

    @Provides
    @Named("FirstHashMap")
    public HashMap<String, String> provideDependentHashMap() {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("firstkey", "firstVal");
        map.put("secondkey", "secondVal");
        return map;
    }
}
