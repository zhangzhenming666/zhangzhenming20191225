package com.bawei.zhangzhenming20191225.view.adapter;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangzhenming20191225.R;
import com.bawei.zhangzhenming20191225.model.bean.Bean;
import com.bawei.zhangzhenming20191225.util.NetUtil;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
   List<Bean.ResultBean> list = new ArrayList<>();

    public MyAdapter(List<Bean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_my_adapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Bean.ResultBean resultBean = list.get(position);
     holder.name.setText(resultBean.getCommodityName());
//     holder.price.setText(resultBean.getPrice());
        NetUtil.getInstance().getPhoto(resultBean.getMasterPic(),holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onlitemClickListener != null) {
                    onlitemClickListener.OnlitemClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
       TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.tv);
            price = itemView.findViewById(R.id.tv1);
        }
    }
    OnlitemClickListener onlitemClickListener;

    public void setOnlitemClickListener(OnlitemClickListener onlitemClickListener) {
        this.onlitemClickListener = onlitemClickListener;
    }

    public interface  OnlitemClickListener{
        void OnlitemClick(int presenter);
    }


}
