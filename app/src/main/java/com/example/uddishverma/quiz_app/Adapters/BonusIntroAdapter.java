package com.example.uddishverma.quiz_app.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uddishverma.quiz_app.R;


/**
 * Created by uddishverma on 13/01/18.
 */

public class BonusIntroAdapter extends PagerAdapter {

    private Context context;
    private int[] images;
    private String[] title;
    private String[] description;

    public BonusIntroAdapter(Context context, int[] images, String[] title, String[] description) {
        this.context = context;
        this.images = images;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getCount() {
        return images.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View itemView = inflater.inflate(R.layout.bonus_guidelines_layout, container,
                false);
        ImageView guidelinesImages = itemView.findViewById(R.id.guideline_image);
        TextView guidelinesDescription = itemView.findViewById(R.id.guideline_description);
        TextView guidelinesTitle = itemView.findViewById(R.id.guideline_text);
        guidelinesImages.setImageResource(images[position]);
        guidelinesTitle.setText(title[position]);
        guidelinesDescription.setText(description[position]);

        ((ViewPager) container).addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
