package com.minsait.template.injection.base.activity;

import android.app.Activity;
import android.content.Context;

import com.minsait.template.app.presentation.navigation.Navigator;
import com.minsait.template.injection.base.ApplicationComponent;
import com.minsait.template.injection.subcomponents.detail.DetailSubcomponent;
import com.minsait.template.injection.subcomponents.home.HomeSubcomponent;

import dagger.Component;

/**
 * Created by Alejandro Sánchez
 **/
@Component(

        modules = {
                ActivityModule.class,
                GatewayModule.class
        },

        dependencies = ApplicationComponent.class

)
@ActivityScope
public interface ActivityComponent {

    Context providesContext();

    Activity providesActivity();

    Navigator providesNavigator();

    HomeSubcomponent.Builder homeSubcomponentBuilder();

    DetailSubcomponent.Builder detailSubcomponentBuilder();

}
