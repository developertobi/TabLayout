package com.qe989cm.tablayout.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qe989cm.tablayout.R;
import com.qe989cm.tablayout.adapter.SkillIqAdapter;
import com.qe989cm.tablayout.models.SkillIq;
import com.qe989cm.tablayout.rest.APIClient;
import com.qe989cm.tablayout.rest.GADSSkillIIqEndpoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeaders extends Fragment {

    GADSSkillIIqEndpoint gadsSkillIIqEndpoint;
    RecyclerView skillIQRV;
    RecyclerView.Adapter myAdapter;
    List<SkillIq> myDataSource = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gadsSkillIIqEndpoint = APIClient.getClient().create(GADSSkillIIqEndpoint.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        skillIQRV = rootView.findViewById(R.id.skill_iq_rv);
        skillIQRV.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new SkillIqAdapter(myDataSource);

        skillIQRV.setAdapter(myAdapter);

        loadSkillIQLeaders();

        return rootView;
    }

    private void loadSkillIQLeaders() {
        gadsSkillIIqEndpoint.getSkill().enqueue(new Callback<List<SkillIq>>() {
            @Override
            public void onResponse(Call<List<SkillIq>> call, Response<List<SkillIq>> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
                Log.d("SkillIQLeaders", "SkillIQ leaders returned " + response.body());
            }

            @Override
            public void onFailure(Call<List<SkillIq>> call, Throwable t) {
                Log.e("SkillIQLeaders", t.toString());
            }
        });
    }
}