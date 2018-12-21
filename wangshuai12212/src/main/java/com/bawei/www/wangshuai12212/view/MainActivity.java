package com.bawei.www.wangshuai12212.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.www.wangshuai12212.Apis;
import com.bawei.www.wangshuai12212.R;
import com.bawei.www.wangshuai12212.bean.HomeBean;
import com.bawei.www.wangshuai12212.presonter.Ipresonter;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;


public class MainActivity extends AppCompatActivity implements IView{


    private Banner tbanner;
    private Ipresonter ipresonter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbanner = findViewById(R.id.tbanner);

        ipresonter = new Ipresonter(this);

        ipresonter.setviewRequest(Apis.HomeURL);

        findViewById(R.id.tiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });

    }


    @Override
    public void setSuccess(final Object data) {
        if(data instanceof HomeBean){
            HomeBean homeBean = (HomeBean) data;

            tbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

            tbanner.setImageLoader(new ImageLoaderInterface<ImageView>() {

                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    HomeBean.DataBean dataBean = (HomeBean.DataBean) path;
                    Glide.with(context).load(dataBean.getIcon()).into(imageView);
                }

                @Override
                public ImageView createImageView(Context context) {
                    ImageView imageView =new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return null;
                }
            });

            tbanner.setImages(homeBean.getData());
            tbanner.start();
        }
    }
}
