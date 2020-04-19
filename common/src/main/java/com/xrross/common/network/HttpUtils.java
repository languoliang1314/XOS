package com.xrross.common.network;

import com.xrross.common.network.callback.ICallBack;
import com.xrross.common.network.callback.IHttpProcessor;

import java.util.Map;

/**
 * 代理对象
 */
public class HttpUtils implements IHttpProcessor {
    private static IHttpProcessor httpProcessor;

    //静态内部类
    public static HttpUtils getInstance(){
        return SingletonHolder.singletonHungry;
    };
    private  static class SingletonHolder{
       private static HttpUtils singletonHungry = new HttpUtils();

    }
    //初始化，切换不同的网络框架
    public void init(IHttpProcessor processor){
        httpProcessor=processor;
    }
    //get请求
    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        httpProcessor.get(url,params,callBack);
    }
    //post请求
    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        httpProcessor.get(url,params,callBack);
    }
}
