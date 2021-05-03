package com.minsait.template.data.gateway;

import com.minsait.template.data.ApiManagerImpl;
import com.minsait.template.data.RequestApi;
import com.minsait.template.data.model.Element;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Alejandro Sánchez
 **/
public class ElementNetworkGatewayImpl implements ElementNetworkGateway {

    private RequestApi requestApi;

    public ElementNetworkGatewayImpl() {

        requestApi = ApiManagerImpl.getInstance().getService();

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
