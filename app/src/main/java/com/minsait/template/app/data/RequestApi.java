package com.minsait.template.app.data;

import com.minsait.template.app.data.model.Element;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alejandro Sánchez
 **/
public interface RequestApi {

    @GET("/v2/beers")
    Call<List<Element>> getCharacters();

}
