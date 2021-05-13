package com.minsait.template.injection.subcomponents.detail;

import com.minsait.template.app.presentation.detail.DetailPresenter;
import com.minsait.template.app.presentation.detail.DetailPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro Sánchez
 **/
@Module
public class DetailModule {

    @Provides
    @DetailScope
    public DetailPresenter providesDetailPresenter(DetailPresenterImpl detailPresenter){
        return detailPresenter;
    }

}
