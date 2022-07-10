package com.example.copythatcainiao5play.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.copythatcainiao5play.R;
import com.example.copythatcainiao5play.bean.ListAppBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommedAppAdapter extends RecyclerView.Adapter<RecommedAppAdapter.ViewHolder> {

    List<ListAppBean> mDatas=new ArrayList<>();
    LayoutInflater mLayoutInflater;

    public RecommedAppAdapter(Context context, List<ListAppBean> beans) {

        this.mDatas = beans;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.template_recommend_app, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListAppBean bean = mDatas.get(position);
        String baseImgUrl="http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
        Picasso.get().load(baseImgUrl+bean.getIcon()).into(holder.imageView);
        holder.textView.setText(bean.getDisplayName());
        holder.textView2.setText((int)bean.getApkSize()/1024/1024+"MB");

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.button)
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
