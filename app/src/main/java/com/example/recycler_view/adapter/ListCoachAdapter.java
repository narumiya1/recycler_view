package com.example.recycler_view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recycler_view.R;
import com.example.recycler_view.model.Coach;

import java.util.ArrayList;

public class ListCoachAdapter extends RecyclerView.Adapter<ListCoachAdapter.ListViewHolder> {

    //arraylist
    private ArrayList<Coach> listCoach ;
    //constructor, parameter array model
    public ListCoachAdapter(ArrayList<Coach> list){
        this.listCoach=list;
    }

    private OnItemClickCallback onitemClickCallback ;
    public void setOnitemClickCallback(OnItemClickCallback onitemClickCallback){
        this.onitemClickCallback = onitemClickCallback ;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coach,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        //model
        Coach coach = listCoach.get(position) ;
        Glide.with(holder.itemView.getContext())
                .load(coach.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(coach.getName());
        holder.tvForm.setText(coach.getFrom());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClickCallback.onItemClicked(listCoach.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCoach.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto ;
        TextView tvName, tvForm ;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvForm = itemView.findViewById(R.id.tv_item_from) ;
        }
    }

    public interface OnItemClickCallback {
        void  onItemClicked(Coach data);
    }
}
