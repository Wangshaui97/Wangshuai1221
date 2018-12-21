package com.bawei.www.wangshuai12212.model;

import android.util.Log;

import com.bawei.www.wangshuai12212.bean.GoodsBean;
import com.bawei.www.wangshuai12212.bean.HandBean;
import com.bawei.www.wangshuai12212.bean.HomeBean;
import com.bawei.www.wangshuai12212.mycallback.MyCallBack;
import com.bawei.www.wangshuai12212.okhttputil.Httputil;
import com.bawei.www.wangshuai12212.okhttputil.ICallBack;

public class IModle implements IM {

    @Override
    public void setResponse(String url, final MyCallBack myCallBack) {
        Httputil.getInstance().getEnqueue(url, HandBean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallBack.setCallback(obj);
            }
            @Override
            public void failed(Exception e) {
                Log.d("ws",""+e);
            }
        });
    }

    @Override
    public void setbodyResponse(String url, final MyCallBack myCallBack) {
        Httputil.getInstance().getEnqueue(url, GoodsBean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
               myCallBack.setCallback(obj);
            }

            @Override
            public void failed(Exception e) {
                Log.d("ws",""+e);
            }
        });
    }

    @Override
    public void setviewResponse(String url, final MyCallBack myCallBack) {
        Httputil.getInstance().getEnqueue(url, HomeBean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallBack.setCallback(obj);
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }
}
