package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TVSeries> data;

    public CardViewAdapter(Context context, ArrayList<TVSeries> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final TVSeries tvSeries = data.get(position);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,getItemCount());
            }
        });

        holder.bindTo(tvSeries);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvSeriesName,tvSeriesDesc;
        private ImageView tvSeriesCover;
        Button btnDelete;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSeriesName = itemView.findViewById(R.id.txtNama);
            tvSeriesDesc = itemView.findViewById(R.id.txtDesct);
            tvSeriesCover = itemView.findViewById(R.id.img);
            btnDelete = itemView.findViewById(R.id.btnHapus);
            layout = itemView.findViewById(R.id.parentLayout);

            itemView.setOnClickListener(this);
        }

        void bindTo(TVSeries tvSeries){
            tvSeriesName.setText(tvSeries.getTvseriesName());
            tvSeriesDesc.setText(tvSeries.getTvseriesDesc());
            Glide.with(context)
                    .load(tvSeries.getTvseriesCoverPhoto())
                    .into(tvSeriesCover);
        }


        public void onClick(View v) {
            TVSeries tvSeries = data.get(getAdapterPosition());
            Intent intent = new Intent(context,DetailFilm.class);
            intent.putExtra("nama",tvSeries.getTvseriesName());
            intent.putExtra("desc",tvSeries.getTvseriesDesc());
            intent.putExtra("img",tvSeries.getTvseriesCoverPhoto());
            intent.putExtra("genre",tvSeries.getTvseriesGenre());
            intent.putExtra("duration",tvSeries.getTvseriesDuration());
            intent.putExtra("producer",tvSeries.getTvseriesProducer());
            intent.putExtra("year",tvSeries.getTvseriesYear());
            context.startActivity(intent);
        }
    }
}
