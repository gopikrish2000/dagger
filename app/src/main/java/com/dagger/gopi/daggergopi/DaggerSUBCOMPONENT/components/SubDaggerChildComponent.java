package com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.components;

import com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.modules.SubDaggerChildModule;
import com.dagger.gopi.daggergopi.activities.SubComponentTestActivity;

import java.util.HashMap;

import javax.inject.Named;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by gopi on 06/03/18.
 */
@Subcomponent(modules = {SubDaggerChildModule.class})
public interface SubDaggerChildComponent {
    @Named("SubFirstHashMap")
    public HashMap<String, String> hashMapWrapper();

//    void inject(SubComponentTestActivity activity);
}
