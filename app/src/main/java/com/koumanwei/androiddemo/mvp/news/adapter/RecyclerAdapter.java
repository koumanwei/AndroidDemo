package com.koumanwei.androiddemo.mvp.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koumanwei.androiddemo.R;
import com.koumanwei.androiddemo.mvp.news.bean.NewsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 2017-04-27 上午11:39
 *
 * @author koumanwei
 * @version 1.0
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NewsViewHolder> {
    private Context context;
    private List<NewsBean> dataList;

    public RecyclerAdapter(Context context, List<NewsBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.tvTitle.setText(dataList.get(position).getTitle());
        holder.tvContent.setText(dataList.get(position).getContent());
        holder.tvComment.setText(String.valueOf(dataList.get(position).getComment()));
        holder.ivImage.setImageResource(dataList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_comment)
        TextView tvComment;

        NewsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
