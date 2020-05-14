package com.xrross.solutionprovider.fsmainview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.view.BasePager;

public class SecondFragment  extends BasePager {
    public SecondFragment(Context context) {
        super(context);
    }

    public SecondFragment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int setContentView() {
        return R.layout.fs_second_pager_view;
    }
}
