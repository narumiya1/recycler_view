package com.example.recycler_view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recycler_view.R;
import com.example.recycler_view.model.Coach;

import java.util.ArrayList;

public class GridCoachAdapter extends RecyclerView.Adapter<GridCoachAdapter.GridViewHolder> {

    private ArrayList<Coach> listdCoach;

    public GridCoachAdapter(ArrayList<Coach> list) {
        this.listdCoach = list;
    }

    private ListCoachAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(ListCoachAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_coach, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listdCoach.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhotoGird);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listdCoach.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listdCoach.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotoGird;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhotoGird = itemView.findViewById(R.id.img_item_grid_photo);

        }
    }

    public interface onItemClickCallback {
        void onItemClicked(Coach data);
    }
}
