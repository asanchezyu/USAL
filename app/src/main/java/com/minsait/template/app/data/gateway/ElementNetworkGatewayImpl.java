package com.minsait.template.app.data.gateway;

import com.minsait.template.app.data.RequestApi;
import com.minsait.template.app.data.model.Element;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Alejandro Sánchez
 **/
public class ElementNetworkGatewayImpl implements ElementNetworkGateway {

    private RequestApi requestApi;

    @Inject
    public ElementNetworkGatewayImpl(RequestApi requestApi) {

        this.requestApi = requestApi;

    }

    @Override
    public List<Element> requestNetworkElements() {

        Call<List<Element>> charactersCall = requestApi.getCharacters();

        try {

            Response<List<Element>> response = charactersCall.execute();

            if (response.isSuccessful()) {

                return response.body();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }

}
