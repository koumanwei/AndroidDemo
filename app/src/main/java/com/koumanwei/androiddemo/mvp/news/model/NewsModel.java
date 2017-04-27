package com.koumanwei.androiddemo.mvp.news.model;

import com.koumanwei.androiddemo.mvp.news.bean.NewsBean;

import java.util.List;

/**
 * 2017-04-27 下午2:30
 *
 * @author koumanwei
 * @version 1.0
 */

public interface NewsModel {
    List<NewsBean> getNewsData();
}
