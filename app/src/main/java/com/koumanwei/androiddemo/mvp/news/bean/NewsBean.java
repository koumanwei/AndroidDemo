package com.koumanwei.androiddemo.mvp.news.bean;

/**
 * 2017-04-27 上午11:10
 *
 * @author koumanwei
 * @version 1.0
 */

public class NewsBean {
    private String title;
    private String content;
    private int comment;
    private int image;

    public NewsBean() {
    }

    public NewsBean(String title, String content, int comment, int image) {
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
