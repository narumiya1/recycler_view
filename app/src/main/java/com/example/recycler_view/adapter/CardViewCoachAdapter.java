package com.example.recycler_view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recycler_view.R;
import com.example.recycler_view.model.Coach;

import java.util.ArrayList;

public class CardViewCoachAdapter extends RecyclerView.Adapter<CardViewCoachAdapter.CardViewVolder> {

    private ArrayList<Coach> listCoach;

    public CardViewCoachAdapter(ArrayList<Coach> list) {
        this.listCoach = list;
    }

    @NonNull
    @Override
    public CardViewVolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewVolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewVolder holder, int position) {

        Coach coach = listCoach.get(position);

        Glide.with(holder.itemView.getContext())
                .load(coach.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(coach.getName());
        holder.tvFrom.setText(coach.getFrom());

        holder.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "favourite" + listCoach.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "share" + listCoach.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "kamu memilih " + listCoach.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCoach.size();
    }

    class CardViewVolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName, tvFrom;
        Button btnFav, btnShare;

        CardViewVolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_view_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            btnFav = itemView.findViewById(R.id.btn_set_favourite);
            btnShare = itemView.findViewById(R.id.btn_share);


        }
    }
}
