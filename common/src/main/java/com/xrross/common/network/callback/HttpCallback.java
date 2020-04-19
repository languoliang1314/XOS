package com.xrross.common.network.callback;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class HttpCallback<T> implements ICallBack{
    @Override
    public void onSuccess(String result) {
        //将数据转成json对象
        Gson  gson=new Gson();
        Class<?> clz= analysisClassInfo(this);
        T objectResult= (T) gson.fromJson(result,clz);

    }
    //获取 Result 对象
    private Class<?> analysisClassInfo(Object object) {
        //可以获取包含原始类型，参数化类型，类型变量，基本类型
        Type genType=object.getClass().getGenericSuperclass();
        Type[] typeArgrument=((ParameterizedType)genType).getActualTypeArguments();

        return (Class<?>) typeArgrument[0];

    }

    public abstract void onSuccess(T result);
}
