package com.dagger.gopi.daggergopi.daggercomponent;

import com.dagger.gopi.daggergopi.MainActivity;
import com.dagger.gopi.daggergopi.annotations.DependentDaggerCompAnnotation;
import com.dagger.gopi.daggergopi.daggermodules.DependentDaggerModule;

import java.util.HashMap;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gopi on 06/03/18.
 */
@DependentDaggerCompAnnotation
@Component(dependencies = {FirstDaggerComponent.class}, modules = {DependentDaggerModule.class})
public interface DependentDaggerComponent {

    @Named("FirstHashMap")
    public HashMap<String, String> getDefaultFirstHashMap();

//    void injectMainActivity1(MainActivity activity);
}
