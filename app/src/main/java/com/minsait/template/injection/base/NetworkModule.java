package com.minsait.template.injection.base;

import com.minsait.template.app.data.RequestApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alejandro Sánchez
 **/
@Module
public class NetworkModule {

    private static final int CONNECT_TIMEOUT = 600;

    private static final int WRITE_TIMEOUT = 600;

    private static final int READ_TIMEOUT = 600;

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor bodyInterceptor) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);

        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);

        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);

        builder.addInterceptor(bodyInterceptor);

        return builder.build();

    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor providesHttpLoggingInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofitBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public RequestApi providesRequestApi(Retrofit retrofit){

        return retrofit.create(RequestApi.class);

    }

}
