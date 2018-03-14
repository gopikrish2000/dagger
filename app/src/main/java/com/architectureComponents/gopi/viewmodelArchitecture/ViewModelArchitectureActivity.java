package com.architectureComponents.gopi.viewmodelArchitecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.dagger.gopi.daggergopi.R;

public class ViewModelArchitectureActivity extends AppCompatActivity {

    private FirstViewModel firstViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_architecture);
        firstViewModel = ViewModelProviders.of(this).get(FirstViewModel.class);
        firstViewModel.nameLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                System.out.println(" Data change in UI layer = " + s);
            }
        });
        firstViewModel.convertedLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                System.out.println(" convertedLiveData change in UI layer = " + s);
            }
        });

        firstViewModel.changeLiveData();
    }
}
