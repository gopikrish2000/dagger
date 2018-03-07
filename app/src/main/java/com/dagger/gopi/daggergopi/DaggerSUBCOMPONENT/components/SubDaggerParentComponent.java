package com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.components;

import com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.modules.SubDaggerFirstModule;
import com.dagger.gopi.daggergopi.activities.SubComponentTestActivity;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by gopi on 06/03/18.
 */

@Component(modules = {SubDaggerFirstModule.class})
public interface SubDaggerParentComponent {
    void inject(SubComponentTestActivity activity);

    SubDaggerChildComponent getChildSubComponent();
}
