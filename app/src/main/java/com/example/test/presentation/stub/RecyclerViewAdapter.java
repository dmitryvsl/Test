package com.example.test.presentation.stub;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.domain.model.SportNew;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewVH> {

    List<SportNew> data;
    LayoutInflater inflater;

    public RecyclerViewAdapter(Context context, List<SportNew> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new RecyclerViewVH(view);
    }

    public void setItems(List<SportNew> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewVH holder, int position) {
        SportNew item = data.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(item.getImgUrl())
                .centerCrop()
                .into(holder.imageView);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.readTime.setText(item.getReadTime());
        holder.views.setText(String.valueOf(item.getViews()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewVH extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView title;
        private final TextView description;
        private final TextView readTime;
        private final TextView views;


        public RecyclerViewVH(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            readTime = itemView.findViewById(R.id.read_time);
            views = itemView.findViewById(R.id.views);
        }
    }

}
