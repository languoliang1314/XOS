package com.xrross.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

public class AppListUtil {

    //获取用户安装的APP
    public static List<ResolveInfo> getInstalledApplication(Context context,String[] unShowApp, boolean needSysAPP) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, 0);

        //排除系统应用
        if (!needSysAPP) {
            for (int i = 0; i < resolveInfos.size(); i++) {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                try {
                    if (isSysApp(context, resolveInfo.activityInfo.packageName)) {
                        resolveInfos.remove(resolveInfo);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    resolveInfos.remove(resolveInfo);
                }
            }
        }

        //排除指定PP
        if (unShowApp!=null) {
            //排除特定APP
            for (int i=0;i<resolveInfos.size();i++){
                ResolveInfo resolveInfo = resolveInfos.get(i);
                for(int j=0;j<unShowApp.length;j++){
                    if (resolveInfo.activityInfo.packageName.equals(unShowApp[j])){
                        try{
                            resolveInfos.remove(resolveInfo);

                        }catch (Exception e){
                            e.printStackTrace();
                            resolveInfos.remove(resolveInfo);
                        }
                    }
                }

            }
        }



        return resolveInfos;
    }

    //判断是否系统应用
    public static boolean isSysApp(Context context, String packageName) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
