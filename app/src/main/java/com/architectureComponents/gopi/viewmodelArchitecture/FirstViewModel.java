package com.architectureComponents.gopi.viewmodelArchitecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

/**
 * Created by gopi on 13/03/18.
 */

public class FirstViewModel extends ViewModel {

    MutableLiveData<String> nameLiveData;
    public LiveData<String> convertedLiveData;  // for immutable Data using Transformations

    public FirstViewModel() {
        nameLiveData = new MutableLiveData<>();
        convertedLiveData = Transformations.map(nameLiveData, s -> s + "converted");  // used transformations instead of created new MutableLiveData instances , if someone else want to listen to different data ( which can be converted from an existing MutableLiveData.
        nameLiveData.postValue("first");
    }

    public void changeLiveData() {
        nameLiveData.setValue("second");
    }

     public void printLiveData() {
        nameLiveData.getValue();
     }
}
