package com.ondevice.mynewapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ondevice.mynewapp.R;
import com.ondevice.mynewapp.ShowDataActivity;
import com.ondevice.mytestmodule.Beans.BasicInfoBean;

import java.util.List;

public class BasicInfoAdapter extends RecyclerView.Adapter<BasicInfoAdapter.ViewHolder> {

    Context contxt;
    List<BasicInfoBean> BasicInfoList;

    public BasicInfoAdapter(Context context, List<BasicInfoBean> basicInfoBeans) {

        this.contxt = context;
        this.BasicInfoList = basicInfoBeans;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public BasicInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(contxt).inflate(R.layout.raw_basicinfo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return BasicInfoList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BasicInfoAdapter.ViewHolder holder, int position) {
        BasicInfoBean items = BasicInfoList.get(position);

        Glide.with(contxt)
                .load(items.getImageurl())
                .into(holder.imgBasic);
        holder.txtBasicName.setText(items.getName());
        //holder.txtBasicName.setText(items.getActName());

        holder.llShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contxt, ShowDataActivity.class);
                i.putExtra("abcd", items.getName());
                i.putExtra("image", items.getImageurl());
                contxt.startActivity(i);

            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgBasic;
        public TextView txtBasicName;
        LinearLayout llShowData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBasic = itemView.findViewById(R.id.imgBasic);
            txtBasicName = itemView.findViewById(R.id.txtBasicName);
            llShowData = itemView.findViewById(R.id.llShowData);
        }
    }
}
