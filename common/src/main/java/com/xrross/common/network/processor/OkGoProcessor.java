package com.xrross.common.network.processor;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;
import com.xrross.common.network.callback.ICallBack;
import com.xrross.common.network.callback.IHttpProcessor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkGoProcessor implements IHttpProcessor {
    private OkHttpClient mClient;
    public OkGoProcessor(){
        initHttpClient();

    }

    private void initHttpClient(){
        new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor("OKGO"))//这里可以继续添加多种拦截器
                //.addInterceptor(new TokenInterceptor(context1))//添加获取token的拦截器
                .build();
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallBack callBack) {
        OkGo.<String>get(url)
                .client(mClient)
                .params(appendyParams(params))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        callBack.onSuccess(response.body());
                    }
                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        callBack.onSuccess(response.message());
                    }
                });
    }

    @Override
    public void post(String url, Map<String, Object> params,final ICallBack callBack) {
        OkGo.<String>post(url)
                .client(mClient)
                .params(appendyParams(params))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        callBack.onSuccess(response.body());
                    }
                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        callBack.onSuccess(response.message());
                    }
                });

    }

    /**
     * 拼接参数
     */
    public HttpParams appendyParams(Map<String, Object> params) {
        HttpParams params1=new HttpParams();

        for (Map.Entry<String, Object> map : params.entrySet()) {
            params1.put(map.getKey(), map.getValue().toString());
        }
        return params1;
    }

}
