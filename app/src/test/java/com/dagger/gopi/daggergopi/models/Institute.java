package com.dagger.gopi.daggergopi.models;

/**
 * Created by gopi on 13/03/18.
 */

public class Institute {

    String name;
    String address;



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
