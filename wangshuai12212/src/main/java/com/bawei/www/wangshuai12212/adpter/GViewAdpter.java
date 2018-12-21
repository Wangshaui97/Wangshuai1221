package com.bawei.www.wangshuai12212.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.www.wangshuai12212.R;
import com.bawei.www.wangshuai12212.bean.HandBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class GViewAdpter extends RecyclerView.Adapter<GViewAdpter.ViewHolder> {

    private Context context;
    private List<HandBean.DataBean> mlist;

    public GViewAdpter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }

    @NonNull
    @Override
    public GViewAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.title_item, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull GViewAdpter.ViewHolder viewHolder, int i) {
        viewHolder.title_item_tt.setText(mlist.get(i).getName());
        Glide.with(context).load(mlist.get(i).getIcon()).into(viewHolder.title_item_img);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<HandBean.DataBean> beanData) {
        this.mlist = beanData;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title_item_tt;
        private final ImageView title_item_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_item_tt = itemView.findViewById(R.id.title_item_tt);
            title_item_img = itemView.findViewById(R.id.title_item_img);
        }
    }
}
