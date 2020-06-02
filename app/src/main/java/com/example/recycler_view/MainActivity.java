package com.example.recycler_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.recycler_view.adapter.CardViewCoachAdapter;
import com.example.recycler_view.adapter.GridCoachAdapter;
import com.example.recycler_view.adapter.ListCoachAdapter;
import com.example.recycler_view.data.CoachData;
import com.example.recycler_view.model.Coach;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private String title = "Mode list" ;

    private RecyclerView rvCoach ;
    private ArrayList<Coach> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle(title);

        rvCoach= findViewById(R.id.rv_coach);
        rvCoach.setHasFixedSize(true);

        list.addAll(CoachData.getListData()) ;
        
        showRecyclerList();

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null ) {
            getSupportActionBar().setTitle(title);
        }
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

    private void showRecyclerGrid(){
        rvCoach.setLayoutManager(new GridLayoutManager(this, 2));
        GridCoachAdapter gridCoachAdapter = new GridCoachAdapter(list);
        rvCoach.setAdapter(gridCoachAdapter);

        gridCoachAdapter.setOnItemClickCallback(new ListCoachAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Coach data) {
                showSelectedCoach(data);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_list:
                title = "mode list";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "mode grid" ;
                showRecyclerGrid();
                break;
            case R.id.action_card:
                title = "mode card";
                showRecyclerCardView();
                break;
        }
    }

}
