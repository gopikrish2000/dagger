package com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.modules;

import java.util.HashMap;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gopi on 06/03/18.
 */
@Module
public class SubDaggerChildModule {

    @Provides
    @Named("SubFirstHashMap")
    public HashMap<String, String> provideSubHashMap() {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("Subfirstkey", "SubfirstVal");
        map.put("Subsecondkey", "SubsecondVal");
        return map;
    }
}
