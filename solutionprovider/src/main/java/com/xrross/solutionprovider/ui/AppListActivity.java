package com.xrross.solutionprovider.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.xrross.common.base.BaseActivity;
import com.xrross.common.utils.AppListUtil;
import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.adapter.ViewAdapter;
import com.xrross.solutionprovider.view.AppsPager;
import com.xrross.solutionprovider.view.IndicatorView;

import java.util.ArrayList;
import java.util.List;

public class AppListActivity extends BaseActivity {
    private ViewPager viewPager;
    private IndicatorView indicatorView;
    private ViewAdapter mAdapter;
    private List<View> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_app_list);
        initView();
        initData();
    }
    @Override
    protected void initView() {
        viewPager=findViewById(R.id.view_pager);
        indicatorView=findViewById(R.id.indicator);
    }
    @Override
    protected void initData() {
        addApp();
        mAdapter = new ViewAdapter(list);
        viewPager.setAdapter(mAdapter);
        indicatorView.bindViewPapger(viewPager);
    }

    private void addApp(){
        List<ResolveInfo> appList= AppListUtil.getInstalledApplication(this,null,true);
        int pages = appList.size()/12;
        if (appList.size()%12 !=0){
            pages++;
        }

        for (int i=0;i<pages;i++) {
            AppsPager pager = new AppsPager(this);
            List<ResolveInfo> tmp = new ArrayList<>();

            for (int j=0;j<12;j++){
                int index = 12*i + j;
                if (index >= appList.size()){
                    break;
                }

                tmp.add(appList.get(index));
            }
            pager.setApps(tmp);

            list.add(pager);
        }
    }
}
