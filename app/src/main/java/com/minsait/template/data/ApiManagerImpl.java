package com.minsait.template.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alejandro Sánchez
 **/
public class ApiManagerImpl {

    private RequestApi service;

    private static ApiManagerImpl instance;

    private ApiManagerImpl() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RequestApi.class);
    }

    public static ApiManagerImpl getInstance() {

        if( instance == null ){

                instance = new ApiManagerImpl();

        }

        return instance;

    }

    public RequestApi getService() {
        return service;
    }

}
