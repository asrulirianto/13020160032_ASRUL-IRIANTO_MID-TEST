package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailFilm extends AppCompatActivity {
    private Toolbar toolbar;
    String[] nama, desc, genre, producer, year, duration;
    TypedArray photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Detail Film");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView Name = findViewById(R.id.txtJudul);
        TextView Desc = findViewById(R.id.txtDesc);
        TextView Genre = findViewById(R.id.txtGenre);
        TextView Duration = findViewById(R.id.txtDuration);
        TextView Producer = findViewById(R.id.txtProducer);
        TextView Year = findViewById(R.id.txtProduction);
        ImageView CoverPhoto = findViewById(R.id.img);

        Name.setText(getIntent().getStringExtra("nama"));
        Desc.setText(getIntent().getStringExtra("desc"));
        Glide.with(this)
                .load(getIntent().getIntExtra("img", 0))
                .into(CoverPhoto);
        Genre.setText(getIntent().getStringExtra("genre"));
        Duration.setText(getIntent().getStringExtra("duration"));
        Producer.setText(getIntent().getStringExtra("producer"));
        Year.setText(getIntent().getStringExtra("year"));


        nama = getResources().getStringArray(R.array.tvSeriesName);
        desc = getResources().getStringArray(R.array.tvSeriesDesc);
        producer = getResources().getStringArray(R.array.tvSeriesProducer);
        genre = getResources().getStringArray(R.array.tvSeriesGenre);
        duration = getResources().getStringArray(R.array.tvSeriesDuration);
        year = getResources().getStringArray(R.array.tvSeriesYear);
        photo = getResources().obtainTypedArray(R.array.tvSeriesCoverPhoto);


    }
}


