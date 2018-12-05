package com.example.elvis.videoplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerTestAdapter extends PagerAdapter {
    private List<View> mImageViewList;
    private Context mContext;

    MyPagerTestAdapter(List<View> list, Context context){
        super();
        mImageViewList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (mImageViewList != null && mImageViewList.size() > 0){
            container.addView(mImageViewList.get(position));
            return mImageViewList.get(position);
        }
        return null;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (mImageViewList != null && mImageViewList.size() > 0){
            container.removeView(mImageViewList.get(position));
        }
    }

    @Override
    public int getCount() {
        if (mImageViewList != null){
            return mImageViewList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}

