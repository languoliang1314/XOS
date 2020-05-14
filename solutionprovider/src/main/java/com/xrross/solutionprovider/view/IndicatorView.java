package com.xrross.solutionprovider.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xrross.solutionprovider.R;

public class IndicatorView extends LinearLayout {

    private ViewPager viewPager;
    private int currentItem;
    private int count;

    public IndicatorView(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
    }

    public void bindViewPapger(ViewPager viewPager){
        this.removeAllViews();
        this.viewPager = viewPager;
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeCurrnetItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        currentItem = this.viewPager.getCurrentItem();
        count = this.viewPager.getAdapter().getCount();

        for (int i=0;i<count;i++){
            View item = new View(getContext());
            if (i == currentItem){
                item.setBackgroundResource(R.drawable.bg_indicator_selected);
            }else {
                item.setBackgroundResource(R.drawable.bg_indicator_unselect);
            }
            LayoutParams params = new LayoutParams(8,8);
            if (i != 0){
                params.leftMargin = 12;
            }
            item.setLayoutParams(params);
            addView(item);
        }
    }

    private void changeCurrnetItem(int index){
        if (getChildAt(currentItem) != null) {
            getChildAt(currentItem).setBackgroundResource(R.drawable.bg_indicator_unselect);
        }

        if (getChildAt(index) != null) {
            getChildAt(index).setBackgroundResource(R.drawable.bg_indicator_selected);
        }

        currentItem = index;
    }
}
