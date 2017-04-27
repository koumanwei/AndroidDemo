package com.koumanwei.androiddemo.mvp.news.view;

import com.koumanwei.androiddemo.mvp.news.bean.NewsBean;

import java.util.List;

/**
 * 2017-04-27 上午11:18
 *
 * @author koumanwei
 * @version 1.0
 */

public interface NewsView {
    void showNews(List<NewsBean> news);
}
