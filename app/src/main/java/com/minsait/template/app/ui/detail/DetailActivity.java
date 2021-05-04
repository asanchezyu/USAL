package com.minsait.template.app.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.app.data.model.Element;
import com.minsait.template.app.presentation.detail.DetailPresenter;
import com.minsait.template.app.presentation.detail.DetailView;
import com.minsait.template.app.ui.BaseActivity;
import com.minsait.template.injection.subcomponents.detail.DetailModule;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class DetailActivity extends BaseActivity implements DetailView {

    private final static String K_ELEMENT = "com.minsait.template.app.ui.detail.DetailActivity:ELEMENT";

    private Element element;

    private TextView tvTitle;

    private TextView tvDescription;

    private ImageView ivProfile;

    private RecyclerView rvFoodPairing;

    @Inject
    DetailPresenter detailPresenter;

    public static final Intent getLaunchIntent(Activity activity, Element element){

        Intent intent = new Intent(activity, DetailActivity.class);

        intent.putExtra(K_ELEMENT, element);

        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        initViews();

        initInjection();

        element = (Element) getIntent().getSerializableExtra(K_ELEMENT);

        detailPresenter.setElement(element);

    }

    private void initInjection(){

        getActivityComponent().detailSubcomponentBuilder().detailModule(new DetailModule()).build().inject(this);

        detailPresenter.setView(this);

    }

    private void initViews() {

        tvDescription = findViewById(R.id.tvDescription);

        tvTitle = findViewById(R.id.tvTitle);

        ivProfile = findViewById(R.id.ivProfile);

        rvFoodPairing = findViewById(R.id.rvFoodPairing);

    }

    @Override
    public void setTitle(String title) {

        tvTitle.setText(title);

    }

    @Override
    public void setImageUrl(String url) {

        Picasso.get().load(url).into(ivProfile);

    }

    @Override
    public void setDescription(String description) {

        tvDescription.setText(element.description);

    }

    @Override
    public void setFoodPairing(List<String> foodPairings) {

        rvFoodPairing.setAdapter(new FoodPairingAdapter(element.foodPairing));

    }
}
