package com.example.elvis.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    private List<View> mViewList;
    private ViewPager mViewPager;
    private ImageView[] mDotList;
    private int mLastPostition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initViewPager();
        initDots();
    }

    private void initDots() {
        LinearLayout dotsLinearLayout = findViewById(R.id.ll_dots_layout);
        mDotList = new ImageView[mViewList.size()];
        for (int i = 0; i <mViewList.size() ; i++){
            mDotList[i] = (ImageView) dotsLinearLayout.getChildAt(i);
            mDotList[i].setEnabled(false);
        }
        mLastPostition = 0;
        mDotList[0].setEnabled(true);
    }

    //先把三个xml初始化为View视图
    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        mViewList = new ArrayList<>();
        mViewList.add(inflater.inflate(R.layout.guide_one,null));
        mViewList.add(inflater.inflate(R.layout.guide_two,null));
        mViewList.add(inflater.inflate(R.layout.guide_three,null));

    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyPagerAdapter adapter = new MyPagerAdapter(mViewList, this);
//        MyPagerTestAdapter adapter1 = new MyPagerTestAdapter(mViewList,this);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        setCurrentDotPostion(i);

    }


    @Override
    public void onPageScrollStateChanged(int i) {

    }


    private void setCurrentDotPostion(int position) {
        mDotList[position].setEnabled(true);
        mDotList[mLastPostition].setEnabled(false);
        mLastPostition = position;

    }

    public void turnToHome(View view) {
            setGuided();
            Intent intent = new Intent(GuideActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
    }

    private void setGuided() {
        SharedPreferences sp = getSharedPreferences("config",MODE_PRIVATE);
        sp.edit().putBoolean("mIsFirstIn",false).commit();

    }

    class MyPagerAdapter extends PagerAdapter {

        private List<View> mImageViewList;
        private Context mContext;

        MyPagerAdapter(List<View> list, Context context){
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
}
