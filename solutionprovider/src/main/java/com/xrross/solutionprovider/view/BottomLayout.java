package com.xrross.solutionprovider.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.ui.AppListActivity;

public class BottomLayout extends LinearLayout {
    public BottomLayout(Context context) {
        super(context);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_layout,this);

    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    //初始化
    private void init(final Context context){

    }
}
