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
import com.qe989cm.tablayout.models.SkillIq;

import java.util.List;

public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.ViewHolder> {
    private List<SkillIq> skillIqLeaders;

    public SkillIqAdapter(List<SkillIq> skillIqLeaders) {
        this.skillIqLeaders = skillIqLeaders;
    }


    @NonNull
    @Override
    public SkillIqAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View learningLeadersLayout = inflater.inflate(R.layout.skill_iq_list, parent, false);

        return new ViewHolder(learningLeadersLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqAdapter.ViewHolder holder, int position) {
        SkillIq skillIq = skillIqLeaders.get(position);

//        holder.imageView.setImageURI(learning.getBadgeUrl());
        holder.name.setText(skillIq.getName());
        holder.skillIqCountry.setText(skillIq.getScore() + " skill IQ score, " + skillIq.getCountry());
    }

    @Override
    public int getItemCount() {
        return skillIqLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, skillIqCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.skill_leader_name);
            skillIqCountry = itemView.findViewById(R.id.skill_leader_hour_country);
        }
    }
}
