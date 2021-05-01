package com.minsait.template.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.api.model.Element;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private Element element;

    private TextView tvTitle;

    private TextView tvDescription;

    private ImageView ivProfile;

    private RecyclerView rvFoodPairing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        initViews();

        element = (Element) getIntent().getSerializableExtra("ELEMENT");

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
