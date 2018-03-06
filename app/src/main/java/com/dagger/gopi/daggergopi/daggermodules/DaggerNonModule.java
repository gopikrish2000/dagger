package com.dagger.gopi.daggergopi.daggermodules;

import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by gopi on 27/02/18.
 */

public class DaggerNonModule {
    Executor executor;

    @Inject
    public DaggerNonModule(Executor executor) {  // Constructor injection of all dependencies of it
        this.executor = executor;
    }

    public void printExecutorStatement() {
        executor.execute(() -> System.out.println("Inside the Run method DaggerNonModule *** "));
    }
}
