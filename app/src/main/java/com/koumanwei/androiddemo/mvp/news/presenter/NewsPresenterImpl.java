package com.koumanwei.androiddemo.mvp.news.presenter;

import com.koumanwei.androiddemo.mvp.news.bean.NewsBean;
import com.koumanwei.androiddemo.mvp.news.model.NewsModel;
import com.koumanwei.androiddemo.mvp.news.model.NewsModelImpl;
import com.koumanwei.androiddemo.mvp.news.view.NewsView;

import java.util.List;

/**
 * 2017-04-27 下午2:27
 *
 * @author koumanwei
 * @version 1.0
 */

public class NewsPresenterImpl implements NewsPresenter {
    private NewsView newsView;
    private NewsModel newsModel;

    public NewsPresenterImpl(NewsView newsView) {
        this.newsView = newsView;
        this.newsModel = new NewsModelImpl();
    }

    @Override
    public void loadList() {
        List<NewsBean> newsData = newsModel.getNewsData();
        newsView.showNews(newsData);
    }
}
