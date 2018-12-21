package com.bawei.www.wangshuai12212.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bawei.www.wangshuai12212.Apis;
import com.bawei.www.wangshuai12212.R;
import com.bawei.www.wangshuai12212.adpter.GViewAdpter;
import com.bawei.www.wangshuai12212.adpter.RecycViewAdptar;
import com.bawei.www.wangshuai12212.bean.GoodsBean;
import com.bawei.www.wangshuai12212.bean.HandBean;
import com.bawei.www.wangshuai12212.presonter.Ipresonter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements IView {

    private Ipresonter ipresonter;
    private RecyclerView hand;
    private GViewAdpter gd;
    private RecyclerView rview;
    private RecycViewAdptar rd;
    private Boolean p = true;
    private List<GoodsBean.DataBean.ListBean> listBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ipresonter = new Ipresonter(this);

        initData();
        initView();
        initClick();
    }

    private void initClick() {
        findViewById(R.id.zxing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ZXingActivity.class));
            }
        });

        findViewById(R.id.qiehuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p==true){
                    rview.setLayoutManager(new GridLayoutManager(HomeActivity.this,2));
                    p=false;
                }else {
                    rview.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
                    p=true;
                }
            }
        });


        rd.setItemOnClicklisenter(new RecycViewAdptar.onClickCallBack() {
            @Override
            public void setItemOnClick(int i) {
                Toast.makeText(HomeActivity.this,""+listBeans.get(i).getDetailUrl(),Toast.LENGTH_SHORT).show();;
            }
        });
    }

    private void initView() {
        hand = findViewById(R.id.hand);
        gd = new GViewAdpter(this);
        hand.setLayoutManager(new GridLayoutManager(this, 5));
        hand.setAdapter(gd);
        hand.setItemAnimator(new DefaultItemAnimator());


        rview = findViewById(R.id.rview);
        rd = new RecycViewAdptar(this);
        rview.setLayoutManager(new LinearLayoutManager(this));
        rview.setAdapter(rd);
        rview.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ipresonter.setRequest(Apis.HOME_TITLE_URL);
        ipresonter.setbodyRequest(Apis.HOME_DELIES_URL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ipresonter != null) {
            ipresonter = null;
        }
    }

    @Override
    public void setSuccess(Object data) {
        if (data instanceof HandBean) {
            HandBean handBean = (HandBean) data;
            List<HandBean.DataBean> beanData = handBean.getData();
            gd.setData(beanData);
        } else if (data instanceof GoodsBean) {
            GoodsBean goodsBean = (GoodsBean) data;
            listBeans = goodsBean.getData().get(2).getList();
            rd.setData(listBeans);
        }

    }

}
