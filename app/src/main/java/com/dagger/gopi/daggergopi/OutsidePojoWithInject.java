package com.dagger.gopi.daggergopi;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gopi on 27/02/18.
 */
@Singleton
public class OutsidePojoWithInject {

    private Executor executor;

    @Inject  // Constructor injection
    public OutsidePojoWithInject(Executor executor) {
        this.executor = executor;
    }

    public void printExecutorStatement() {
        executor.execute(() -> System.out.println("OutsidePojoWithInject runnable printing *** "));
    }
}
