package com.example.elvis.videoplayer;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.elvis.videoplayer.base.BaseFragment;

/**
 * Created by Tianyi Gu(elvis) on 6/12/2018.
 * Describe:
 */
public class BlogFragment extends BaseFragment {

    private WebView mWebView;
    private ProgressBar mProgressBar;
    private static final  int MAX_VALUE= 100;
    private static final  String BLOG_URL = "https://m.baidu.com/";

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_blog;
    }

    @Override
    protected void initView() {
        mWebView = bindViewId(R.id.webview);
        mProgressBar = bindViewId(R.id.pb_progress);
        WebSettings settings = mWebView.getSettings();//用来设置webview的属性
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        mProgressBar.setMax(MAX_VALUE);
        mWebView.loadUrl(BLOG_URL);
        mWebView.setWebViewClient(mWebViewClient);
    }

    //阻止弹出系统浏览器 在内部加载
    private WebViewClient mWebViewClient = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient(){

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mProgressBar.setProgress(newProgress);//加载过程中更新进度
            if (newProgress == MAX_VALUE) {
                mProgressBar.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    };

    @Override
    protected void initData() {

    }
}
