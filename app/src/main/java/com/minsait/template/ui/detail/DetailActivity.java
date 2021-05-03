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
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private final static String K_ELEMENT = "com.minsait.template.ui.detail.DetailActivity:ELEMENT";

    private Element element;

    private TextView tvTitle;

    private TextView tvDescription;

    private ImageView ivProfile;

    private RecyclerView rvFoodPairing;

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

        element = (Element) getIntent().getSerializableExtra(K_ELEMENT);

        initData(element);

    }

    private void initViews() {
        tvDescription = findViewById(R.id.tvDescription);

        tvTitle = findViewById(R.id.tvTitle);

        ivProfile = findViewById(R.id.ivProfile);

        rvFoodPairing = findViewById(R.id.rvFoodPairing);
    }

    private void initData(Element element) {
        Picasso.get().load(element.imageUrl).into(ivProfile);

        tvTitle.setText(element.name);

        tvDescription.setText(element.description);

        rvFoodPairing.setAdapter(new FoodPairingAdapter(element.foodPairing));

    }

}
