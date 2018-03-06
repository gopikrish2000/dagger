package com.dagger.gopi.daggergopi.pojos;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by gopi on 06/03/18.
 */

public class DummyConstructorInjection {

    public final List<String> list;

    @Inject
    public DummyConstructorInjection(@Named("DummyList") List<String> list) {
        this.list = list;
    }

    public void print() {
        System.out.println("dummyList " + list);
    }
}
