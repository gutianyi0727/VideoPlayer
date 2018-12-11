package com.example.elvis.videoplayer;

import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import com.example.elvis.videoplayer.base.BaseFragment;

/**
 * Created by Tianyi Gu(elvis) on 6/12/2018.
 * Describe:
 */
public class AboutFragment extends BaseFragment {
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initView() {
        TextView textView = bindViewId(R.id.tv_app_des);
        textView.setAutoLinkMask(Linkify.ALL);//表示文字中有链接可点
        textView.setMovementMethod(LinkMovementMethod.getInstance());//表示文字可以滚动
    }

    @Override
    protected void initData() {

    }
}
