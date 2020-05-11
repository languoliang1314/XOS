package com.xrross.solutionprovider.view;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.util.AttributeSet;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xrross.common.view.GridSpacingItemDecoration;
import com.xrross.solutionprovider.R;
import com.xrross.solutionprovider.adapter.AppListAdapter;

import java.util.List;

public class AppsPager extends RecyclerView {

    private Context context;
    private AppListAdapter adapter;

    public AppsPager(Context context) {
        super(context);
        init(context);
    }

    public AppsPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        this.context = context;
        this.setLayoutManager(new GridLayoutManager(context,6));
        float spacing = context.getResources().getDimension(R.dimen.applist_grid_spacing);
        this.addItemDecoration(new GridSpacingItemDecoration(6,(int)spacing,true));
    }

    public void setApps(List<ResolveInfo> list){
        adapter = new AppListAdapter(context);
        setAdapter(adapter);
        adapter.refresh(list);
    }
}
