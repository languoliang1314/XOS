package com.xrross.solutionprovider.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xrross.common.base.BaseFragment;
import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.adapter.ViewAdapter;
import com.xrross.solutionprovider.fsmainview.FourthFragment;
import com.xrross.solutionprovider.fsmainview.FsFirstPager;
import com.xrross.solutionprovider.fsmainview.SecondFragment;
import com.xrross.solutionprovider.fsmainview.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class FeiShiFragment extends BaseFragment {
    private ViewPager mViewPager;
    private ViewAdapter mAdapter;

    private List<View> mViewList=new ArrayList<>();
    @Override
    public View setLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feishi,container,false);
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        mViewPager=view.findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(1);
        mViewList.add(new FsFirstPager(getActivity()));
        mViewList.add(new SecondFragment(getActivity()));
        mViewList.add(new ThirdFragment(getActivity()));
        mViewList.add(new FourthFragment(getActivity()));
        mAdapter=new ViewAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);

    }

    @Override
    public void initData() {
        super.initData();
    }
}
