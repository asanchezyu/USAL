package com.minsait.template.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.data.model.Element;
import com.minsait.template.presentation.home.HomePresenter;
import com.minsait.template.presentation.home.HomePresenterImpl;
import com.minsait.template.presentation.home.HomeView;
import com.minsait.template.ui.config.navigation.NavigatorImpl;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private RecyclerView rvElements;

    private Button btRequest;

    private ElementsAdapter elementsAdapter;

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        initPresenter();

        initViews();

        initListeners();

        initRetrofit();
    }

    private void initPresenter() {

        homePresenter = new HomePresenterImpl(new NavigatorImpl(this));

        homePresenter.setView(this);

    }

    private void initRetrofit() {


    }

    private void initViews() {

        rvElements = findViewById(R.id.rvElements);

        btRequest = findViewById(R.id.btSearch);

        rvElements.setLayoutManager(new LinearLayoutManager(this));

        elementsAdapter = new ElementsAdapter(new ArrayList<Element>(), new ElementListener() {

            @Override
            public void onClickElement(Element element) {

                homePresenter.goToElementDetail(element);

            }
        });

        rvElements.setAdapter(elementsAdapter);

    }

    private void initListeners() {

        btRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                homePresenter.makeElementsRequest();

            }

        });

    }

    @Override
    public void setElements(List<Element> elements) {

        elementsAdapter.addElements(elements);

        elementsAdapter.notifyDataSetChanged();

    }
}
