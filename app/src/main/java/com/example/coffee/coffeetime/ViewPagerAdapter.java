package com.example.coffee.coffeetime;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {

    int[] images = {
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider3,
            R.drawable.slider4
    };
    Context context;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context){
        this.context = context;

    }


    @Override
    public int getCount(){
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object){
//        return (view ==(LinearLayout) object);
        return view == object;
    }
    //
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
//

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = (layoutInflater.inflate((R.layout.activity_slide),null));
        ImageView imageView = (ImageView) view.findViewById(R.id.slideimageView);

        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }
}
