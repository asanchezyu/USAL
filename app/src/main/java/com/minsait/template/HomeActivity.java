package com.minsait.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

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

    public interface RequestApi {

        @GET("/v2/beers")
        Call<List<Element>> getCharacters();

    }

    public final class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ElementViewHolder> {

        private List<Element> elements;

        private ElementListener elementListener;

        public ElementsAdapter(List<Element> elements, ElementListener elementListener) {
            this.elements = elements;
            this.elementListener = elementListener;
        }

        public void addElements(List<Element> newElements) {

            if (elements != null) {
                elements.clear();
            }

            elements.addAll(newElements);

        }

        @NonNull
        @Override
        public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_data, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
            holder.bind(elements.get(position), elementListener);
        }

        @Override
        public int getItemCount() {

            return elements.size();

        }

        public final class ElementViewHolder extends RecyclerView.ViewHolder {

            private TextView tvTitle;
            private TextView tvSubtitle;
            private CircleImageView civProfile;

            public ElementViewHolder(@NonNull View itemView) {
                super(itemView);
                initView();
            }

            private void initView() {
                tvTitle = itemView.findViewById(R.id.tvItemTitle);
                tvSubtitle = itemView.findViewById(R.id.tvItemSubtitle);
                civProfile = itemView.findViewById(R.id.civProfile);
            }

            public void bind(Element element, ElementListener elementListener) {
                tvTitle.setText(element.name);
                tvSubtitle.setText(element.description);
                Picasso.get().load(element.imageUrl).placeholder(R.drawable.ipa_logo).into(civProfile);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (elementListener != null) {
                            elementListener.onClickElement(element);
                        }

                    }
                });
            }

        }

    }

    public interface ElementListener {
        void onClickElement(Element element);
    }

}
