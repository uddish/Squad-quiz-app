package com.example.uddishverma.quiz_app.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.uddishverma.quiz_app.Activities.MainActivity;
import com.example.uddishverma.quiz_app.Activities.QuizActivity;
import com.example.uddishverma.quiz_app.Adapters.BonusIntroAdapter;
import com.example.uddishverma.quiz_app.R;

/**
 * Created by uddishverma on 11/01/18.
 */

public class BonusGuidelinesFragment extends Fragment implements View.OnClickListener {

    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    private ProgressBar progressBar;
    private RelativeLayout confirmLayout;

    int[] guidelinesImages;
    String[] guidelinesTitle;
    String[] guidelinesDesc;

    public BonusGuidelinesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        guidelinesImages = new int[]{R.drawable.bonus_intro, R.drawable.bonus_enroll
                , R.drawable.bonus_leaderboard};

        guidelinesTitle = new String[]{getString(R.string.bonus_guidelines_title_1),
                getString(R.string.bonus_guidelines_title_2),
                getString(R.string.bonus_guidelines_title_4)};

        guidelinesDesc = new String[]{getString(R.string.bonus_guidelines_description_1),
                getString(R.string.bonus_guidelines_description_2),
                getString(R.string.bonus_guidelines_description_4)};

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bonus_guideline, container, false);
        viewPager = view.findViewById(R.id.bonus_pager_guideline);
        floatingActionButton = view.findViewById(R.id.fab_guideline);
        progressBar = view.findViewById(R.id.progbar_bonus_guideline);
        confirmLayout = view.findViewById(R.id.confirm_layout);
        floatingActionButton.setOnClickListener(this);
        confirmLayout.setOnClickListener(this);

        PagerAdapter pagerAdapter = new BonusIntroAdapter(getContext(),
                guidelinesImages, guidelinesTitle, guidelinesDesc);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == guidelinesImages.length - 1) {
                    confirmLayout.setVisibility(View.VISIBLE);
                    floatingActionButton.setVisibility(View.INVISIBLE);
                } else {
                    confirmLayout.setVisibility(View.INVISIBLE);
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
                progressBar.setProgress((100 / guidelinesImages.length) * (position + 1));
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_guideline:
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                break;
            case R.id.confirm_layout:
                startActivity(new Intent(getContext(), QuizActivity.class));
                break;
        }
    }
}
