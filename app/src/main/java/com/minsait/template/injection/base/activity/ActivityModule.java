package com.minsait.template.injection.base.activity;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.minsait.template.app.presentation.navigation.Navigator;
import com.minsait.template.app.ui.config.navigation.NavigatorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro Sánchez
 **/
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Context providesContext() {
        return activity;
    }

    @Provides
    @ActivityScope
    public Activity providesActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity providesAppCompatActivity() {
        return (AppCompatActivity)activity;
    }

    @Provides
    @ActivityScope
    public Navigator providesNavigator(NavigatorImpl navigator) {
        return navigator;
    }

}
