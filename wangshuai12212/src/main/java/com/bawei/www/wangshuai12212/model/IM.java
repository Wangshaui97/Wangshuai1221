package com.bawei.www.wangshuai12212.model;

import com.bawei.www.wangshuai12212.mycallback.MyCallBack;

public interface IM {
    void setResponse(String url, MyCallBack myCallBack);
    void setbodyResponse(String url, MyCallBack myCallBack);
    void setviewResponse(String url, MyCallBack myCallBack);
}
