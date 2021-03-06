package com.minsait.template.app.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.app.data.model.Element;
import com.minsait.template.app.presentation.home.HomePresenter;
import com.minsait.template.app.presentation.home.HomeView;
import com.minsait.template.app.ui.BaseActivity;
import com.minsait.template.app.ui.spinner.CSpinnerDialogImpl;
import com.minsait.template.injection.subcomponents.home.HomeModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements HomeView {

    private RecyclerView rvElements;

    private Button btRequest;

    private ElementsAdapter elementsAdapter;

    private CSpinnerDialogImpl customSpinnerDialog;

    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        initInjection();

        initViews();

        initListeners();

    }

    private void initInjection() {

        getActivityComponent().homeSubcomponentBuilder().homeModule(new HomeModule()).build().inject(this);

        homePresenter.setView(this);

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

        customSpinnerDialog = new CSpinnerDialogImpl(this);

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

    @Override
    public void showSpinner() {
        customSpinnerDialog.show();
    }

    @Override
    public void hideSpinner() {
        if (customSpinnerDialog != null && customSpinnerDialog.isShowing()) {
            customSpinnerDialog.dismiss();
        }
    }

    @Override
    public boolean isSpinnerShowing() {
        return customSpinnerDialog.isShowing();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putParcelableArrayList("elements", elementsAdapter.getElements());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Element> data = savedInstanceState.getParcelableArrayList("elements");
        if( data != null ){
            setElements(data);
        }
    }
}
