package com.xrross.common.network.callback;

import java.util.Map;
/*
代理接口
 */
public interface IHttpProcessor {
    //get请求
    void get(String url, Map<String,Object> params,ICallBack callBack);
    //post请求
    void post(String url,Map<String,Object> params,ICallBack callBack);
}
