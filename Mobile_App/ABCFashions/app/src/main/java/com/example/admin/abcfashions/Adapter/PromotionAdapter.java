package com.example.admin.abcfashions.Adapter;

/**
 * Created by rajitha on 3/30/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.abcfashions.Model.Promotion;
import com.example.admin.abcfashions.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.MyViewHolder> {

    private Context mContext;
    private List<Promotion> albumList;
    IProcessFilter callback;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);
            overflow = view.findViewById(R.id.overflow);
        }
    }


    public PromotionAdapter(Context mContext, List<Promotion> albumList, IProcessFilter callback) {
        this.mContext = mContext;
        this.albumList = albumList;
        this.callback=callback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Promotion promotion = albumList.get(position);
        holder.title.setText(promotion.getName());
        holder.count.setText(promotion.getRate()+ " rate");
        Picasso.with(mContext).load(promotion.getUrl()).into(holder.thumbnail);

    }

    /**
     * Click listener for popup menu items
     */


    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public interface AdapterInterface
    {
        void onClick(String value);
    }

    public interface IProcessFilter {
        void onProcessFilter(int string1);
    }

}