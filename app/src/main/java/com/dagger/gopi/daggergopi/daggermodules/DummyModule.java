package com.dagger.gopi.daggergopi.daggermodules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 06/03/18.
 */
@Module
public class DummyModule {

    @Provides
    @Named("DummyList")
    public List<String> provideDummyArrayList() {
        return Arrays.asList(new String[]{"a", "b", "c"});
    }
}
