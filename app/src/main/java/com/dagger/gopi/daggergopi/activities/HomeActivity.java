package com.dagger.gopi.daggergopi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.architectureComponents.gopi.FirstArchitectureComponentActivity;
import com.architectureComponents.gopi.viewmodelArchitecture.ViewModelArchitectureActivity;
import com.dagger.gopi.daggergopi.MainActivity;
import com.dagger.gopi.daggergopi.R;

public class HomeActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.home_btn).setOnClickListener((view) -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.subcomp_btn).setOnClickListener((view) -> {
            Intent intent = new Intent(HomeActivity.this, SubComponentTestActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.first_architecture_btn).setOnClickListener((view) -> {
            Intent intent = new Intent(HomeActivity.this, ViewModelArchitectureActivity.class);
            startActivity(intent);
        });
    }
}
