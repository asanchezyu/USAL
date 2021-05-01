package com.minsait.template.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.api.RequestApi;
import com.minsait.template.api.model.Element;
import com.minsait.template.detail.DetailActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvElements;

    private Button btRequest;

    private RequestApi service;

    private ElementsAdapter elementsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        initViews();

        initListeners();

        initRetrofit();
    }

    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RequestApi.class);

    }

    private void initViews() {

        rvElements = findViewById(R.id.rvElements);

        btRequest = findViewById(R.id.btSearch);

        rvElements.setLayoutManager(new LinearLayoutManager(this));

        elementsAdapter = new ElementsAdapter(new ArrayList<Element>(), new ElementListener() {

            @Override
            public void onClickElement(Element element) {

                HomeActivity.this.goToDetail(element);

            }
        });

        rvElements.setAdapter(elementsAdapter);

    }

    private void initListeners() {

        btRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                makeRequest();

            }

        });

    }

    private void makeRequest() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Call<List<Element>> charactersCall = service.getCharacters();

                try {

                    Response<List<Element>> response = charactersCall.execute();

                    if (response.isSuccessful()) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                elementsAdapter.addElements(response.body());

                                elementsAdapter.notifyDataSetChanged();


                            }
                        });


                    }

                } catch (
                        IOException e) {

                    e.printStackTrace();

                }

            }
        });

        thread.start();
    }

    private void goToDetail(Element element) {

        Intent intent = new Intent(HomeActivity.this, DetailActivity.class);

        intent.putExtra("ELEMENT", element);

        startActivity(intent);

    }

}
