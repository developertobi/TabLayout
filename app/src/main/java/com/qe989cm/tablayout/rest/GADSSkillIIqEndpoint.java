package com.qe989cm.tablayout.rest;

import com.qe989cm.tablayout.models.SkillIq;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GADSSkillIIqEndpoint {
    @GET("/api/skilliq")
    Call<List<SkillIq>> getSkill();
}
