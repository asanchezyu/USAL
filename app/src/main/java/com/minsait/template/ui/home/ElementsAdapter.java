package com.minsait.template.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minsait.template.R;
import com.minsait.template.data.model.Element;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Alejandro Sánchez
 **/
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
