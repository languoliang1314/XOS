package com.xrross.common.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.xrross.common.network.HttpUtils;
import com.xrross.common.network.callback.ICallBack;
import com.xrross.common.utils.GPSUtils;

import java.util.HashMap;

public class UploadLocationService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        GPSUtils.getInstance(this)
                .getLngAndLat(new GPSUtils.OnLocationResultListener() {
                    @Override
                    public void onLocationResult(Location location) {
                        if(location!=null){
                            uploadLocation(location.getLatitude(),location.getLongitude());
                        }
                    }
                    @Override
                    public void OnLocationChange(Location location) {
                        if(location!=null){
                            uploadLocation(location.getLatitude(),location.getLongitude());
                        }
                    }
                });
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void  uploadLocation(double latitude, double longitude){
        HashMap<String,Object> params=new HashMap<>();
        params.put("imie","aa");
        params.put("latitude",latitude);
        params.put("longitude",longitude);
        HttpUtils.getInstance()
                .post("https://api.xrross.cn/api/car/position/upload", params, new ICallBack() {
                    @Override
                    public void onSuccess(String result) {

                    }
                    @Override
                    public void onFails(String message) {

                    }
                });
    }
}
