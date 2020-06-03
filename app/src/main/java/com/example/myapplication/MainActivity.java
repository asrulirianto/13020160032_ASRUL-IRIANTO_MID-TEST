package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TVSeries> data = new ArrayList<>();
    private RecyclerView recyclerView;
    String[] nama,desc,genre,producer,year,duration,realname,castname;
    TypedArray photo,castphoto;
    private Toolbar toolbar;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final CardViewAdapter recyclerViewAdapter = new CardViewAdapter(this,data);
        recyclerView.setAdapter(recyclerViewAdapter);
        getData();
        recyclerViewAdapter.notifyDataSetChanged();
    }

    void prepare(){
        nama = getResources().getStringArray(R.array.tvSeriesName);
        desc = getResources().getStringArray(R.array.tvSeriesDesc);
        producer = getResources().getStringArray(R.array.tvSeriesProducer);
        genre = getResources().getStringArray(R.array.tvSeriesGenre);
        duration = getResources().getStringArray(R.array.tvSeriesDuration);
        year = getResources().getStringArray(R.array.tvSeriesYear);
        photo = getResources().obtainTypedArray(R.array.tvSeriesCoverPhoto);
    }

    void addItem(){
        for(int i=0; i<nama.length;i++){
            TVSeries tvSeries = new TVSeries(nama[i],desc[i],genre[i],duration[i],producer[i],year[i],photo.getResourceId(i,-1));
            data.add(tvSeries);
        }
    }
    void getData(){
        prepare();
        addItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.grid_view){
            Intent intent = new Intent(this,GridView.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.id_about){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
