package com.architectureComponents.gopi;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

/**
 * Created by gopi on 13/03/18.
 */

public class SampleLifeCycleListener implements LifecycleObserver {

    private final Lifecycle lifecycle;

    public SampleLifeCycleListener(Context context, Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void doInOnStart() {
        System.out.println("SampleLifeCycleListener.doInOnStart " + lifecycle.getCurrentState());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void doInOnStop() {
        System.out.println("SampleLifeCycleListener.doInOnStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void doInOnDestroy() {
        System.out.println("SampleLifeCycleListener.doInOnDestroy");
        lifecycle.removeObserver(this);
    }
}
