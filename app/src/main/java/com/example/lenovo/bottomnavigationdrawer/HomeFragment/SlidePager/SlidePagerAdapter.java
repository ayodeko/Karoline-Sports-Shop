package com.example.lenovo.bottomnavigationdrawer.HomeFragment.SlidePager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.bottomnavigationdrawer.R;

public class SlidePagerAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SlidePagerAdapter(Context context){
        this.context = context;
    }

    private  int[] slideImages = {

            R.drawable.willian_chelsea,
            R.drawable.chelsea_kit

    };

    /*public String[] slideTitles = {
            "Fashion",
            "Accessories",
            "Style"
    };

    public String[] slideDescriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit dolor sit amet, consectetur adipiscing",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit dolor sit amet, consectetur adipiscing",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit dolor sit amet, consectetur adipiscing"
    };*/

    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        //TextView slideTitle = view.findViewById(R.id.textTitle);
        //TextView slideDescription = view.findViewById(R.id.textDescription);

        imageView.setImageResource(slideImages[position]);
        //slideTitle.setText(slideTitles[position]);
        //slideDescription.setText(slideDescriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

}
