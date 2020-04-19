package com.xrross.solutionprovider.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.xrross.solutionprovider.R;

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
    private void init(Context context){

    }
}
