package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TVSeries> data;

    public GridViewAdapter(Context context, ArrayList<TVSeries> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_grid,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TVSeries tvSeries = data.get(position);
        holder.nama.setText(tvSeries.getTvseriesName());
        holder.photo.setImageResource(tvSeries.getTvseriesCoverPhoto());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,tvSeries.getTvseriesName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nama;
        private ImageView photo;
        LinearLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.txtNama);
            photo = itemView.findViewById(R.id.img);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
