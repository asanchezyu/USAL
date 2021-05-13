package com.minsait.template.injection.base.activity;

import com.minsait.template.app.data.gateway.ElementNetworkGateway;
import com.minsait.template.app.data.gateway.ElementNetworkGatewayImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro Sánchez
 **/
@Module
public class GatewayModule {

    @Provides
    @ActivityScope
    public ElementNetworkGateway providesElementNetworkGateway(ElementNetworkGatewayImpl elementNetworkGateway) {
        return elementNetworkGateway;
    }

}
