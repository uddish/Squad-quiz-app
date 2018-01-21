package com.example.uddishverma.quiz_app.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uddishverma.quiz_app.Adapters.QuizPagerAdapter;
import com.example.uddishverma.quiz_app.R;

/**
 * Created by uddishverma on 20/01/18.
 */

public class QuizFragment extends Fragment {

    public QuizFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_layout, container, false);

        ViewPager viewPager = view.findViewById(R.id.quiz_viewpager);

        PagerAdapter pagerAdapter = new QuizPagerAdapter(getContext());
        viewPager.setAdapter(pagerAdapter);

        return view;
    }
}