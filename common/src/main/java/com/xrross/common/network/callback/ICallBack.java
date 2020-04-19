package com.xrross.common.network.callback;

public interface ICallBack {
    //成功回调
    void onSuccess(String result);
    //失败回调
    void onFails(String message);
}
