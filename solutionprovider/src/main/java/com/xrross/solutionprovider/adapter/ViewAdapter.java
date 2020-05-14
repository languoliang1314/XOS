package com.xrross.solutionprovider.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class ViewAdapter extends PagerAdapter {
    private List<View> viewList;

    public ViewAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    public void refresh(List<View> list){
        this.viewList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);
        view.setId(position);
        container.addView(view);
        return view;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
