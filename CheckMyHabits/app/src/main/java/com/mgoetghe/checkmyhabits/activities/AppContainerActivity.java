package com.mgoetghe.checkmyhabits.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.mgoetghe.checkmyhabits.R;

/**
 * This activity is the container for our whole application.
 * It handles different views to display using its FrameLayout defined inside its layout, views stack and transitions between those views
 *
 * Created by mgoet on 02-09-17.
 */

public class AppContainerActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.app_container_activity);
    }

}
