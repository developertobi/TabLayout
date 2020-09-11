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
import com.qe989cm.tablayout.adapter.HoursAdapter;
import com.qe989cm.tablayout.models.Learning;
import com.qe989cm.tablayout.rest.APIClient;
import com.qe989cm.tablayout.rest.GADSHoursEndpoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaders extends Fragment {

    GADSHoursEndpoint gadsHoursEndpoint;
    RecyclerView learningLeadersRV;
    RecyclerView.Adapter myAdapter;
    List<Learning> myDataSource = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gadsHoursEndpoint = APIClient.getClient().create(GADSHoursEndpoint.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        
        learningLeadersRV = rootView.findViewById(R.id.learning_leader_rv);
        learningLeadersRV.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new HoursAdapter(myDataSource);
        
        learningLeadersRV.setAdapter(myAdapter);
        
        loadLearningLeaders();

        return rootView;
    }

    private void loadLearningLeaders() {
        gadsHoursEndpoint.getUsers().enqueue(new Callback<List<Learning>>() {
            @Override
            public void onResponse(Call<List<Learning>> call, Response<List<Learning>> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
                Log.d("LearningLeaders", "Learning leaders returned " + response.body());
            }

            @Override
            public void onFailure(Call<List<Learning>> call, Throwable t) {
                Log.e("LearningLeaders", t.toString());
            }
        });
    }
}