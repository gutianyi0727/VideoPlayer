package com.example.elvis.videoplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tianyi Gu(elvis) on 6/12/2018.
 * Describe:
 */
public abstract class BaseFragment extends Fragment {

    private View mContentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mContentView = getActivity().getLayoutInflater().inflate(getLayoutID(), container,false);
        initView();
        initData();
        return mContentView;
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();

    protected <T extends View> T bindViewId(int resId){
        return (T) mContentView.findViewById(resId);
    }

}
