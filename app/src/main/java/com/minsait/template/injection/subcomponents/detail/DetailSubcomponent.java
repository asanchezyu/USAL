package com.minsait.template.injection.subcomponents.detail;

import com.minsait.template.app.ui.detail.DetailActivity;

import dagger.Subcomponent;

/**
 * Created by Alejandro Sánchez
 **/
@Subcomponent(

    modules = DetailModule.class

)
@DetailScope
public interface DetailSubcomponent {

    void inject(DetailActivity detailActivity);

    @Subcomponent.Builder
    interface Builder {

        DetailSubcomponent.Builder detailModule(DetailModule module);

        DetailSubcomponent build();

    }

}
