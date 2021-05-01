package com.minsait.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

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

    private class FoodPairingAdapter extends RecyclerView.Adapter <FoodPairingAdapter.FoodPairingViewHolder> {


        private List<String> pairings;

        public FoodPairingAdapter(List<String> pairings) {
            this.pairings = pairings;
        }

        @NonNull
        @Override
        public FoodPairingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FoodPairingViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull FoodPairingViewHolder holder, int position) {
            holder.bind(pairings.get(position));
        }

        @Override
        public int getItemCount() {
            return pairings.size();
        }

        private class FoodPairingViewHolder extends RecyclerView.ViewHolder{

            public FoodPairingViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(String element){

                ((TextView)itemView.findViewById(android.R.id.text1)).setText(element);

            }
        }
    }

}
