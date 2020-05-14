package com.xrross.solutionprovider.fsmainview;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.ui.AppListActivity;
import com.xrross.solutionprovider.view.BasePager;

public class FsFirstPager extends BasePager {
    private Context mContext;
    public FsFirstPager(Context context) {
        super(context);
        mContext=context;
        initView();
    }
    public FsFirstPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView();
    }
    @Override
    protected int setContentView() {
        return R.layout.fs_first_pager_view;
    }
    private void initView(){
        findViewById(R.id.app_list_tv).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, AppListActivity.class));
            }
        });
    }


}
