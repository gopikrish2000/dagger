package com.dagger.gopi.daggergopi.daggercomponent;

import com.dagger.gopi.daggergopi.MainActivity;
import com.dagger.gopi.daggergopi.daggermodules.DaggerFirstModule;
import com.dagger.gopi.daggergopi.daggermodules.DaggerNonModule;
import com.dagger.gopi.daggergopi.daggermodules.DaggerSecondModule;
import com.dagger.gopi.daggergopi.daggermodules.DummyModule;
import com.dagger.gopi.daggergopi.pojos.DummyConstructorInjection;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gopi on 26/02/18.
 */
@Singleton  // Component should have same scope used by any child Modules like DaggerFirstModule method @Singleton...
@Component(modules = { DaggerFirstModule.class, DaggerSecondModule.class, DummyModule.class})  // either comma seperated multiple classes or @Module(includes= ) in DaggerFirstModule
public interface FirstDaggerComponent {
    Executor getProvidedExecutor();  // Wrapper or Additional functionality for component.

    void injectMainActivity(MainActivity mainActivity); // This will make @Inject work in main activity.

    DaggerNonModule getNotAModuleOfDagger();
}
