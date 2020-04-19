package com.xrross.solutionprovider.fsmainview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.view.BasePager;

public class FourthFragment extends BasePager {
    public FourthFragment(Context context) {
        super(context);
    }

    public FourthFragment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int setContentView() {
        return R.layout.fs_second_pager_view;
    }
}
