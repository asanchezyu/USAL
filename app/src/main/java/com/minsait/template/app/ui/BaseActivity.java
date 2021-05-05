package com.minsait.template.app.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.minsait.template.injection.base.activity.ActivityComponent;
import com.minsait.template.injection.base.activity.ActivityModule;
import com.minsait.template.injection.base.activity.DaggerActivityComponent;

/**
 * Created by Alejandro Sánchez
 **/
public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    public final ActivityComponent getActivityComponent() {

        if (activityComponent == null) {

            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(((UsalApplication) getApplication()).getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }

        return activityComponent;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void lockScreenOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}
