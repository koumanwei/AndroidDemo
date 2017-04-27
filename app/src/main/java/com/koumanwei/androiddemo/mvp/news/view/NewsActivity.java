package com.koumanwei.androiddemo.mvp.news.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.koumanwei.androiddemo.R;
import com.koumanwei.androiddemo.mvp.news.adapter.RecyclerAdapter;
import com.koumanwei.androiddemo.mvp.news.bean.NewsBean;
import com.koumanwei.androiddemo.mvp.news.presenter.NewsPresenter;
import com.koumanwei.androiddemo.mvp.news.presenter.NewsPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsView {
    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    private NewsPresenter newPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        newPresenter = new NewsPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        // 加载数据
        newPresenter.loadList();
        super.onStart();
    }

    @Override
    public void showNews(List<NewsBean> news) {
        // 显示来自Model的数据
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvNews.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rvNews.setAdapter(new RecyclerAdapter(this, news));
    }
}
