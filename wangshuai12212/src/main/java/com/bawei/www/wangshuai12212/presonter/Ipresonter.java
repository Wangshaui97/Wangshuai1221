package com.bawei.www.wangshuai12212.presonter;

import com.bawei.www.wangshuai12212.model.IModle;
import com.bawei.www.wangshuai12212.mycallback.MyCallBack;
import com.bawei.www.wangshuai12212.view.IView;

public class Ipresonter implements IP {

    //实例M V；

    IView iView;
    IModle iModle;

    public Ipresonter(IView iView) {
        this.iView = iView;
        iModle = new IModle();
    }

    @Override
    public void setRequest(String url) {
        iModle.setResponse(url, new MyCallBack() {
            @Override
            public void setCallback(Object data) {
                iView.setSuccess(data);
            }
        });
    }

    @Override
    public void setbodyRequest(String url) {
        iModle.setbodyResponse(url, new MyCallBack() {
            @Override
            public void setCallback(Object data) {
                iView.setSuccess(data);
            }
        });
    }

    @Override
    public void setviewRequest(String url) {
        iModle.setviewResponse(url, new MyCallBack() {
            @Override
            public void setCallback(Object data) {
                iView.setSuccess(data);
            }
        });
    }


    // 解除绑定， 解决内存泄露
    public void onDistouch(){
        if(iView!=null){
            iView=null;
        }
        if(iModle!=null){
            iModle=null;
        }
    }
}
