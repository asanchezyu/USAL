package com.minsait.template.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.data.model.Element;
import com.minsait.template.presentation.detail.DetailPresenter;
import com.minsait.template.presentation.detail.DetailPresenterImpl;
import com.minsait.template.presentation.detail.DetailView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private final static String K_ELEMENT = "com.minsait.template.ui.detail.DetailActivity:ELEMENT";

    private Element element;

    private TextView tvTitle;

    private TextView tvDescription;

    private ImageView ivProfile;

    private RecyclerView rvFoodPairing;

    private DetailPresenter detailPresenter;

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

        initPresenter();

        element = (Element) getIntent().getSerializableExtra(K_ELEMENT);

        detailPresenter.setElement(element);

    }

    private void initPresenter() {
         detailPresenter = new DetailPresenterImpl();

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
