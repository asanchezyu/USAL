package com.minsait.template.app.ui.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Alejandro Sánchez
 **/
public class FoodPairingAdapter extends RecyclerView.Adapter<FoodPairingAdapter.FoodPairingViewHolder> {


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

    public final class FoodPairingViewHolder extends RecyclerView.ViewHolder{

        public FoodPairingViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(String element){

            ((TextView)itemView.findViewById(android.R.id.text1)).setText(element);

        }
    }
}
