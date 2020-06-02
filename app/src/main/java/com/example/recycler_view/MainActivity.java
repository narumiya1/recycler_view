package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recycler_view.adapter.CardViewCoachAdapter;
import com.example.recycler_view.adapter.ListCoachAdapter;
import com.example.recycler_view.data.CoachData;
import com.example.recycler_view.model.Coach;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvCoach ;
    private ArrayList<Coach> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCoach= findViewById(R.id.rv_coach);
        rvCoach.setHasFixedSize(true);

        list.addAll(CoachData.getListData()) ;
        
        showRecyclerList();

    }

    private void showRecyclerList() {
        ListCoachAdapter listCoachAdapter = new ListCoachAdapter(list) ;
        rvCoach.setLayoutManager(new LinearLayoutManager(this));
        rvCoach.setAdapter(listCoachAdapter);


        listCoachAdapter.setOnitemClickCallback(new ListCoachAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Coach data) {
                showSelectedCoach(data);
            }
        });
    }

    private void showSelectedCoach(Coach data) {
        Toast.makeText(this, "you choose " +data.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerCardView(){
        rvCoach.setLayoutManager(new LinearLayoutManager(this));
        CardViewCoachAdapter cardViewCoachAdapter = new CardViewCoachAdapter(list);
        rvCoach.setAdapter(cardViewCoachAdapter);
    }


}
