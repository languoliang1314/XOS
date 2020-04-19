package com.xrross.solutionprovider.fsmainview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.view.BasePager;

public class FsFirstPager extends BasePager {
    public FsFirstPager(Context context) {
        super(context);
    }
    public FsFirstPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected int setContentView() {
        return R.layout.fs_first_pager_view;
    }
}
