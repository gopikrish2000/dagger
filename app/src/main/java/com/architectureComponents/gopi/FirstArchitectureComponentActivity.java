package com.architectureComponents.gopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dagger.gopi.daggergopi.R;

public class FirstArchitectureComponentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_architecture_component);
        new SampleLifeCycleListener(this, getLifecycle());
    }
}
