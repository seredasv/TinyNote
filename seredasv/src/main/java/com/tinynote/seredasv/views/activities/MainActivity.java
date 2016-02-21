package com.tinynote.seredasv.views.activities;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.views.MainApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Application application;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MainApplication) getApplication()).getApplicationComponent().inject(this);
    }
}
