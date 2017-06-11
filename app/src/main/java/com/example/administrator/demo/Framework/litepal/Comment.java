package com.example.administrator.demo.Framework.litepal;

/**
 * Created by wangyujie
 * Date 2017/6/11
 * Time 17:58
 * TODO
 */

public class Comment {
    private int id;
    private News news;  //一条评论对应一篇新闻

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
