package com.dagger.gopi.daggergopi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.components.DaggerSubDaggerParentComponent;
import com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.components.SubDaggerChildComponent;
import com.dagger.gopi.daggergopi.DaggerSUBCOMPONENT.components.SubDaggerParentComponent;
import com.dagger.gopi.daggergopi.R;

import java.util.Arrays;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class SubComponentTestActivity extends AppCompatActivity {

    @Inject
    @Named("SubDummyStringAry")
    public String[] dummyStringArray;

    /*@Inject
    @Named("SubFirstHashMap")
    public HashMap<String, String> subHashMap;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_component_test);
        daggerInitialize();
    }

    private void daggerInitialize() {
        SubDaggerParentComponent subDaggerParentComponent = DaggerSubDaggerParentComponent.create();
        SubDaggerChildComponent childSubComponent = subDaggerParentComponent.getChildSubComponent();
        subDaggerParentComponent.inject(this);
//        childSubComponent.inject(this);

        System.out.println("dummyStringArray = " + Arrays.toString(dummyStringArray));
        System.out.println("childSubComponent.hashMapWrapper() = " + childSubComponent.hashMapWrapper());
//        System.out.println("subHashMap injected from ChildSubComponent= " + subHashMap);
    }
}
