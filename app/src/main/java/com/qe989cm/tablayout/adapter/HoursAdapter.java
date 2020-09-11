package com.qe989cm.tablayout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qe989cm.tablayout.R;
import com.qe989cm.tablayout.models.Learning;

import java.util.List;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.ViewHolder> {
    private List<Learning> learningLeaders;

    public HoursAdapter(List<Learning> learningLeaders) {
        this.learningLeaders = learningLeaders;
    }


    @NonNull
    @Override
    public HoursAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View learningLeadersLayout = inflater.inflate(R.layout.learning_list, parent, false);

        return new ViewHolder(learningLeadersLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull HoursAdapter.ViewHolder holder, int position) {
        Learning learning = learningLeaders.get(position);

//        holder.imageView.setImageURI(learning.getBadgeUrl());
        holder.name.setText(learning.getName());
        holder.hoursCountry.setText(learning.getHours() + " learning hours, " + learning.getCountry());
    }

    @Override
    public int getItemCount() {
        return learningLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, hoursCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.leader_name);
            hoursCountry = itemView.findViewById(R.id.leader_hour_country);
        }
    }
}
