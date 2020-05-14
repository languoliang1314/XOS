package com.xrross.solutionprovider.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


public abstract class BasePager extends LinearLayout {


    public BasePager(Context context) {
        super(context);
        initView(context);
    }

    public BasePager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BasePager(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(final Context context){
        LinearLayout.inflate(context,setContentView(),this);
        //长按切换壁纸
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent chooseIntent = new Intent(Intent.ACTION_SET_WALLPAPER);
                // 启动系统选择应用
                Intent intent = new Intent(Intent.ACTION_CHOOSER);
                intent.putExtra(Intent.EXTRA_INTENT, chooseIntent);
                intent.putExtra(Intent.EXTRA_TITLE, "Choosing wallpaper");
                context.startActivity(intent);
                return false;
            }
        });
    }



    protected abstract int setContentView();

}
