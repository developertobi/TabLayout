package com.qe989cm.tablayout.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.qe989cm.tablayout.fragments.LearningLeaders;
import com.qe989cm.tablayout.fragments.SkillIQLeaders;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int noOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int noOfTabs) {
        super(fm, noOfTabs);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LearningLeaders learningLeaders = new LearningLeaders();
                return learningLeaders;
            case 1:
                SkillIQLeaders skillIQLeaders = new SkillIQLeaders();
                return skillIQLeaders;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
