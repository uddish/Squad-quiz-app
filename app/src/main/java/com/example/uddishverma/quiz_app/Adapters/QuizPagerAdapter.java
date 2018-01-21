package com.example.uddishverma.quiz_app.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.uddishverma.quiz_app.R;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by uddishverma on 20/01/18.
 */

public class QuizPagerAdapter extends PagerAdapter {

    private Context context;

    public static final String TAG = "QuizPagerAdapter";

    public QuizPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ScrollView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.fragment_quiz, container,
                false);

        ViewPager viewPager = itemView.findViewById(R.id.image_viewpager);
        final TextView imageCounter = itemView.findViewById(R.id.image_no);

        PagerAdapter pagerAdapter = new QuizImagePagerAdapter(context,
                new int[]{R.drawable.bonus_intro,
                        R.drawable.bonus_enroll,
                        R.drawable.bonus_leaderboard});

        CircleIndicator indicator = (CircleIndicator) itemView.findViewById(R.id.indicator);

        viewPager.setAdapter(pagerAdapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                imageCounter.setText(String.valueOf(position+1) + "/3");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ScrollView) object);
    }
}
