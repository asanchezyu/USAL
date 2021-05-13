package com.minsait.template.app.ui;

import android.app.Application;

import com.minsait.template.injection.base.ApplicationComponent;
import com.minsait.template.injection.base.ApplicationModule;
import com.minsait.template.injection.base.DaggerApplicationComponent;
import com.minsait.template.injection.base.NetworkModule;

/**
 * Created by Alejandro Sánchez
 **/
public class UsalApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        prepareInjection();

    }

    private void prepareInjection() {

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();

        applicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
