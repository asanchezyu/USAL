package com.minsait.template.injection.subcomponents.home;

import com.minsait.template.app.domain.cases.elements.GetElementsUseCase;
import com.minsait.template.app.domain.cases.elements.GetElementsUseCaseImpl;
import com.minsait.template.app.presentation.home.HomePresenter;
import com.minsait.template.app.presentation.home.HomePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro Sánchez
 **/
@Module
public class HomeModule {

    @Provides
    @HomeScope
    public HomePresenter providesHomePresenter(HomePresenterImpl homePresenter){
        return homePresenter;
    }

    @Provides
    @HomeScope
    public GetElementsUseCase providesGetElementsUseCase(GetElementsUseCaseImpl getElementsUseCase){
        return getElementsUseCase;
    }

}
