package com.minsait.template.injection.base;

import android.app.Application;

import com.minsait.template.app.domain.config.MainThread;
import com.minsait.template.app.domain.config.UseCaseExecutor;
import com.minsait.template.app.ui.config.threads.MainThreadImpl;
import com.minsait.template.app.ui.config.threads.UseCaseExecutorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro Sánchez
 **/
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication(){
        return application;
    }

    @Provides
    @Singleton
    public MainThread providesMainThread(MainThreadImpl mainThread) {
        return mainThread;
    }

    @Provides
    @Singleton
    public UseCaseExecutor providesUseCaseExecutor(UseCaseExecutorImpl useCaseExecutor) {
        return useCaseExecutor;
    }

}
