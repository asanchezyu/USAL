package com.minsait.template.injection.subcomponents.home;

import com.minsait.template.app.ui.home.HomeActivity;

import dagger.Subcomponent;

/**
 * Created by Alejandro Sánchez
 **/
@Subcomponent(

    modules = HomeModule.class

)
@HomeScope
public interface HomeSubcomponent {

    void inject(HomeActivity homeActivity);

    @Subcomponent.Builder
    interface Builder {

        HomeSubcomponent.Builder homeModule(HomeModule module);

        HomeSubcomponent build();

    }

}
