package com.qe989cm.tablayout.rest;

import com.qe989cm.tablayout.models.Learning;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GADSHoursEndpoint {
    @GET("/api/hours")
    Call<List<Learning>> getUsers();
}
