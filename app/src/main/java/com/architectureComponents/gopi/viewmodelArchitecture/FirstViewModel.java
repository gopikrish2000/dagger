package com.architectureComponents.gopi.viewmodelArchitecture;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by gopi on 13/03/18.
 */

public class FirstViewModel extends ViewModel {

    MutableLiveData<String> nameLiveData;

    public FirstViewModel() {
        nameLiveData = new MutableLiveData<>();
        nameLiveData.setValue("first");
    }

    public void changeLiveData() {
        nameLiveData.setValue("second");
    }
}
