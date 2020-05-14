package com.xrross.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setLayoutView(inflater,container,savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        findViewById(view);
        initData();
        onEvent();
    }

    /**
     * 设置布局
     *
     * @return
     * @param inflater
     * @param container
     */
    public abstract View setLayoutView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState);

    /**
     * findViewById
     */
    public void findViewById(View view){}

    /**
     * setViewData
     */
    public void initData(){}

    /**
     * setClickEvent
     */
    public void onEvent(){}
}
