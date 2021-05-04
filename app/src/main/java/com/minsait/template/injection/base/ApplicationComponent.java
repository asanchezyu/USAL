package com.minsait.template.injection.base;

import android.app.Application;

import com.minsait.template.app.domain.config.MainThread;
import com.minsait.template.app.domain.config.UseCaseExecutor;
import com.minsait.template.app.ui.UsalApplication;
import com.minsait.template.injection.base.network.NetworkComponent;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Alejandro Sánchez
 **/
@Component(
        modules = {
                ApplicationModule.class,
                NetworkModule.class
        }
)
@Singleton
public interface ApplicationComponent extends NetworkComponent {

    Application providesApplication();

    MainThread providesMainThread();

    UseCaseExecutor providesUseCaseExecutor();

    Retrofit providesRetrofit();

    OkHttpClient providesOkHttpClient();

    void inject(UsalApplication usalApplication);

}
