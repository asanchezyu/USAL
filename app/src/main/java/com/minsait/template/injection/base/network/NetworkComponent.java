package com.minsait.template.injection.base.network;

import com.minsait.template.app.data.RequestApi;
import com.minsait.template.injection.base.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alejandro Sánchez
 **/
@Component(
        modules = NetworkModule.class
)
@Singleton
public interface NetworkComponent {

    RequestApi providesApiService();

}
