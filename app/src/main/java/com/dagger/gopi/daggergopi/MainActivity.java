package com.dagger.gopi.daggergopi;

import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;

import com.dagger.gopi.daggergopi.daggercomponent.DaggerDependentDaggerComponent;
import com.dagger.gopi.daggergopi.daggercomponent.DaggerFirstDaggerComponent;
import com.dagger.gopi.daggergopi.daggercomponent.DependentDaggerComponent;
import com.dagger.gopi.daggergopi.daggercomponent.FirstDaggerComponent;
import com.dagger.gopi.daggergopi.daggermodules.DaggerFirstModule;
import com.dagger.gopi.daggergopi.daggermodules.DaggerSecondModule;
import com.dagger.gopi.daggergopi.daggermodules.DependentDaggerModule;
import com.dagger.gopi.daggergopi.pojos.DummyConstructorInjection;

import java.util.Arrays;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
     @Inject
    Executor executor;
    @Inject
    @Named("dummyStringAry")
    String[] dummyStringAry;

    @Inject
    OutsidePojoWithInject outsidePojoWithInject;  // Constructor Injection without explicit @Provides.

    @Inject
    Pair<Executor, String[]> executorPair;

    @Inject
    DummyConstructorInjection dummyConstructorInjection;

    /*@Inject
    @Named("FirstHashMap")
    public HashMap<String, String> firstHashMap;*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstDaggerComponent firstDaggerComponent = DaggerFirstDaggerComponent.builder().daggerFirstModule(new DaggerFirstModule()).daggerSecondModule(new DaggerSecondModule(getApplicationContext())).build();  // if no Module has a constructor then directly use "DaggerFirstDaggerComponent.create();"
        DependentDaggerComponent dependentDaggerComponent = DaggerDependentDaggerComponent.builder().firstDaggerComponent(firstDaggerComponent).dependentDaggerModule(new DependentDaggerModule()).build();
        firstDaggerComponent.injectMainActivity(this);  // This will make @Inject work.
//        dependentDaggerComponent.injectMainActivity1(this);
//        executor = firstDaggerComponent.getProvidedExecutor();  /*First way to do*/


//        executor.execute(() -> System.out.println("Inside the Run method MainActivity with dummyStringArray " + Arrays.toString(dummyStringAry)));

        firstDaggerComponent.getNotAModuleOfDagger().printExecutorStatement();

        outsidePojoWithInject.printExecutorStatement();

        System.out.println("executorPair first is  " + executorPair.first + " second is " + Arrays.toString(executorPair.second));
        dependentDaggerComponent.getProvidedExecutorOfParent().execute(() -> System.out.println(" Same method as parent working fine in Dependent Component as well"));
        System.out.println("dependentDaggerComponent firstHashMap val is " + dependentDaggerComponent.getDefaultFirstHashMap() + " parent methods ");
//        System.out.println("firstHashMap after injected DependentDaggerComponent = " + firstHashMap);

        dummyConstructorInjection.print();

    }
}
