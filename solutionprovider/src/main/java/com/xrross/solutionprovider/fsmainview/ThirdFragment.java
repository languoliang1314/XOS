package com.xrross.solutionprovider.fsmainview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.view.BasePager;

public class ThirdFragment extends BasePager {
    public ThirdFragment(Context context) {
        super(context);
    }

    public ThirdFragment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int setContentView() {
        return R.layout.fs_second_pager_view;
    }
}
