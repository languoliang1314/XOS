package com.xrross.solutionprovider.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xrross.common.utils.AppListUtil;
import com.xrross.solutionprovider.R;

import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ResolveInfo> list;

    public AppListAdapter(Context context){
        this.context = context;
    }

    public void refresh(List<ResolveInfo> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_app_list,parent,false);
        return new MainAppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MainAppViewHolder mainAppViewHolder = (MainAppViewHolder)holder;
        final ResolveInfo info = list.get(position);
        if (info.activityInfo == null){
            mainAppViewHolder.appNameTv.setText("");
            mainAppViewHolder.appIconIv.setImageResource(R.drawable.btn_app_add);
        }else {
            mainAppViewHolder.appNameTv.setText(info.loadLabel(context.getPackageManager()));
            mainAppViewHolder.appIconIv.setImageDrawable(info.loadIcon(context.getPackageManager()));
        }

//        if (mainAppViewHolder.appNameTv.getText().toString().equals("AVIN")){
//            String packageName = info.activityInfo.packageName;
//            Log.d("packageName",packageName);
//        }

        mainAppViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //APPUtils.openApp(context, info.activityInfo.packageName);
            }
        });
        //长按卸载app
        mainAppViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                try {
                    if (!AppListUtil.isSysApp(context, info.activityInfo.packageName)) {
                        Intent uninstall_intent = new Intent();
                        uninstall_intent.setAction(Intent.ACTION_DELETE);
                        uninstall_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        uninstall_intent.setData(Uri.parse("package:" + info.activityInfo.packageName
                        ));
                        context.startActivity(uninstall_intent);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    private class MainAppViewHolder extends RecyclerView.ViewHolder{

        private ImageView appIconIv;

        private TextView appNameTv;

        public MainAppViewHolder(@NonNull View itemView) {
            super(itemView);
            appIconIv = itemView.findViewById(R.id.iv_app_icon);
            appNameTv = itemView.findViewById(R.id.tv_app_name);
        }

    }
}
